package incometaxcalculator.app.taxpayers;

import java.util.HashMap;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.receipts.ReceiptKind;

public abstract class Taxpayer {
    public final String fullname;
    public final int taxRegistrationNumber;
    public final float income;
    public int totalReceiptsGathered = 0;
    private HashMap<ReceiptKind, Double> amountPerReceiptsKind = new HashMap<ReceiptKind, Double>();

    public HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);

    public abstract double calculateBasicTax();

    protected Taxpayer(String fullname, int taxRegistrationNumber, float income) {
        this.fullname = fullname;
        this.taxRegistrationNumber = taxRegistrationNumber;
        this.income = income;

        this.amountPerReceiptsKind.put(ReceiptKind.BASIC, 0d);
        this.amountPerReceiptsKind.put(ReceiptKind.ENTERTAINMENT, 0d);
        this.amountPerReceiptsKind.put(ReceiptKind.HEALTH, 0d);
        this.amountPerReceiptsKind.put(ReceiptKind.TRAVEL, 0d);
        this.amountPerReceiptsKind.put(ReceiptKind.OTHER, 0d);
    }

    private double getTotalAmountOfReceipts() {
        return this.amountPerReceiptsKind.values().stream().mapToDouble(f -> f).sum();
    }

    public double getVariationTaxOnReceipts() {
        double totalAmountOfReceipts = getTotalAmountOfReceipts();

        if(totalAmountOfReceipts < 0.2 * income)
            return calculateBasicTax() * 0.08;
        else if(totalAmountOfReceipts < 0.4 * income)
            return calculateBasicTax() * 0.04;
        else if(totalAmountOfReceipts < 0.6 * income)
            return -calculateBasicTax() * 0.15;
        else
            return -calculateBasicTax() * 0.3;
    }

    public void addReceipt(Receipt receipt) {
        this.amountPerReceiptsKind.put(receipt.kind, this.amountPerReceiptsKind.get(receipt.kind) + receipt.amount);
        receiptHashMap.put(receipt.id, receipt);
        totalReceiptsGathered++;
    }

    public void removeReceipt(int receiptId) {
        Receipt receipt = receiptHashMap.get(receiptId);
        this.amountPerReceiptsKind.put(receipt.kind, this.amountPerReceiptsKind.get(receipt.kind) - receipt.amount);
        totalReceiptsGathered--;
        receiptHashMap.remove(receiptId);
    }

    public double getTotalTax() {
        return calculateBasicTax() + getVariationTaxOnReceipts();
    }

    public double getBasicTax() {
        return calculateBasicTax();
    }

    public double getAmountOfReceiptKind(ReceiptKind kind) {
        return this.amountPerReceiptsKind.get(kind);
    }
}
