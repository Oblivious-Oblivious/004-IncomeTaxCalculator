package incometaxcalculator.app.taxpayers;

import java.util.Collection;
import java.util.HashMap;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.receipts.ReceiptKind;

public abstract class Taxpayer {
    public String fullname;
    public int tax_registration_number;
    public float income;
    public int total_receipts_gathered = 0;
    
    HashMap<Integer, Receipt> receipts_hashmap = new HashMap<Integer, Receipt>(0);
    HashMap<ReceiptKind, Double> receipt_amounts = new HashMap<ReceiptKind, Double>();

    abstract int[] get_income_bounds();
    abstract double[] get_tax_multipliers();

    double get_total_receipt_amount() {
        return this.receipt_amounts.values().stream().mapToDouble(f -> f).sum();
    }

    public Taxpayer(String fullname, int tax_registration_number, float income) {
        this.fullname = fullname;
        this.tax_registration_number = tax_registration_number;
        this.income = income;

        this.receipt_amounts.put(ReceiptKind.BASIC, 0d);
        this.receipt_amounts.put(ReceiptKind.ENTERTAINMENT, 0d);
        this.receipt_amounts.put(ReceiptKind.HEALTH, 0d);
        this.receipt_amounts.put(ReceiptKind.TRAVEL, 0d);
        this.receipt_amounts.put(ReceiptKind.OTHER, 0d);
    }

    public Receipt get(int receipt_id) {
        return this.receipts_hashmap.get(receipt_id);
    }

    public Collection<Receipt> all_receipts() {
        return this.receipts_hashmap.values();
    }

    public boolean contains(int receipt_id) {
        return this.receipts_hashmap.containsKey(receipt_id);
    }

    public void add_receipt(Receipt receipt) {
        this.receipt_amounts.put(receipt.kind, this.receipt_amounts.get(receipt.kind) + receipt.amount);
        this.receipts_hashmap.put(receipt.id, receipt);
        total_receipts_gathered++;
    }

    public void remove_receipt(int receiptId) {
        Receipt receipt = this.receipts_hashmap.get(receiptId);
        this.receipt_amounts.put(receipt.kind, this.receipt_amounts.get(receipt.kind) - receipt.amount);
        total_receipts_gathered--;
        this.receipts_hashmap.remove(receiptId);
    }

    public double calculate_basic_tax() {
        int income_bounds[] = get_income_bounds();
        double tax_multipliers[] = get_tax_multipliers();

        if(income < income_bounds[0])
            return 0.0535 * income;
        else if(income < income_bounds[1])
            return tax_multipliers[0] + 0.0705 * (income - income_bounds[0]);
        else if(income < income_bounds[2])
            return tax_multipliers[1] + 0.0785 * (income - income_bounds[1]);
        else if(income < income_bounds[3])
            return tax_multipliers[2] + 0.0785 * (income - income_bounds[2]);
        else
            return tax_multipliers[3] + 0.0985 * (income - income_bounds[3]);
    }

    public double get_variation_tax_on_receipts() {
        double totalAmountOfReceipts = get_total_receipt_amount();

        if(totalAmountOfReceipts < 0.2 * income)
            return calculate_basic_tax() * 0.08;
        else if(totalAmountOfReceipts < 0.4 * income)
            return calculate_basic_tax() * 0.04;
        else if(totalAmountOfReceipts < 0.6 * income)
            return -calculate_basic_tax() * 0.15;
        else
            return -calculate_basic_tax() * 0.3;
    }

    public double calculate_total_tax() {
        return calculate_basic_tax() + get_variation_tax_on_receipts();
    }

    public double get_amount_of(ReceiptKind kind) {
        return this.receipt_amounts.get(kind);
    }
}
