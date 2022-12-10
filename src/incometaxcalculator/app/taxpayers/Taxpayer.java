package incometaxcalculator.app.taxpayers;

import java.util.HashMap;

import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.Receipt;

public abstract class Taxpayer {
    private static final short ENTERTAINMENT = 0;
    private static final short BASIC = 1;
    private static final short TRAVEL = 2;
    private static final short HEALTH = 3;
    private static final short OTHER = 4;

    public final String fullname;
    public final int taxRegistrationNumber;
    public final float income;
    public int totalReceiptsGathered = 0;
    private float amountPerReceiptsKind[] = new float[5];

    public HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);

    public abstract double calculateBasicTax();

    protected Taxpayer(String fullname, int taxRegistrationNumber, float income) {
        this.fullname = fullname;
        this.taxRegistrationNumber = taxRegistrationNumber;
        this.income = income;
    }

    private float getTotalAmountOfReceipts() {
        int sum = 0;
        for(int i = 0; i < 5; i++)
            sum += amountPerReceiptsKind[i];
        return sum;
    }

    public double getVariationTaxOnReceipts() {
        float totalAmountOfReceipts = getTotalAmountOfReceipts();

        if(totalAmountOfReceipts < 0.2 * income)
            return calculateBasicTax() * 0.08;
        else if(totalAmountOfReceipts < 0.4 * income)
            return calculateBasicTax() * 0.04;
        else if(totalAmountOfReceipts < 0.6 * income)
            return -calculateBasicTax() * 0.15;
        else
            return -calculateBasicTax() * 0.3;
    }

    public void addReceipt(Receipt receipt) throws WrongReceiptKindException {
        if(receipt.kind.equals("Entertainment"))
            amountPerReceiptsKind[ENTERTAINMENT] += receipt.amount;
        else if(receipt.kind.equals("Basic"))
            amountPerReceiptsKind[BASIC] += receipt.amount;
        else if(receipt.kind.equals("Travel"))
            amountPerReceiptsKind[TRAVEL] += receipt.amount;
        else if(receipt.kind.equals("Health"))
            amountPerReceiptsKind[HEALTH] += receipt.amount;
        else if(receipt.kind.equals("Other"))
            amountPerReceiptsKind[OTHER] += receipt.amount;
        else
            throw new WrongReceiptKindException();

        receiptHashMap.put(receipt.id, receipt);
        totalReceiptsGathered++;
    }

    public void removeReceipt(int receiptId) throws WrongReceiptKindException {
        Receipt receipt = receiptHashMap.get(receiptId);
        if(receipt.kind.equals("Entertainment"))
            amountPerReceiptsKind[ENTERTAINMENT] -= receipt.amount;
        else if(receipt.kind.equals("Basic"))
            amountPerReceiptsKind[BASIC] -= receipt.amount;
        else if(receipt.kind.equals("Travel"))
            amountPerReceiptsKind[TRAVEL] -= receipt.amount;
        else if(receipt.kind.equals("Health"))
            amountPerReceiptsKind[HEALTH] -= receipt.amount;
        else if(receipt.kind.equals("Other"))
            amountPerReceiptsKind[OTHER] -= receipt.amount;
        else
            throw new WrongReceiptKindException();

        totalReceiptsGathered--;
        receiptHashMap.remove(receiptId);
    }

    public double getTotalTax() {
        return calculateBasicTax() + getVariationTaxOnReceipts();
    }

    public double getBasicTax() {
        return calculateBasicTax();
    }

    public float getAmountOfReceiptKind(short kind) {
        return amountPerReceiptsKind[kind];
    }
}
