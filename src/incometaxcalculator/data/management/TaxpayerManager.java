package incometaxcalculator.data.management;

import java.util.HashMap;

import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;

public class TaxpayerManager {
    private static HashMap<Integer, Taxpayer> taxpayerHashMap = new HashMap<Integer, Taxpayer>(0);
    private static HashMap<Integer, Integer> receiptOwnerTRN = new HashMap<Integer, Integer>(0);

    public Taxpayer get_from_taxpayers(int tax_registration_number) {
        return taxpayerHashMap.get(tax_registration_number);
    }

    public int get_from_receipts(int receipt_id) {
        return receiptOwnerTRN.get(receipt_id);
    }

    public void put(int tax_registration_number, Taxpayer new_taxpayer) {
        taxpayerHashMap.put(tax_registration_number, new_taxpayer);
    }

    public void put(int receipt_id, int tax_registration_number) {
        receiptOwnerTRN.put(receipt_id, tax_registration_number);
    }

    public void remove_from_taxpayers(int tax_registration_number) {
        taxpayerHashMap.remove(tax_registration_number);
    }

    public void remove_from_receipts(int receipt_id) {
        receiptOwnerTRN.remove(receipt_id);
    }

    public boolean containsTaxpayer(int taxRegistrationNumber) {
        return taxpayerHashMap.containsKey(taxRegistrationNumber);
    }
    
    public boolean taxpayer_hashmap_is_not_empty() {
        return !taxpayerHashMap.isEmpty();
    }
    
    public boolean containsReceipt(int id) {
        return receiptOwnerTRN.containsKey(id);
    }
    
    public void createTaxpayer(String fullname, int taxRegistrationNumber, String status, float income) throws WrongTaxpayerStatusException {
        if(status.equals("Married Filing Jointly")) {
            put(taxRegistrationNumber, new MarriedFilingJointlyTaxpayer(fullname, taxRegistrationNumber, income));
        }
        else if(status.equals("Married Filing Separately")) {
            put(taxRegistrationNumber, new MarriedFilingSeparatelyTaxpayer(fullname, taxRegistrationNumber, income));
        }
        else if(status.equals("Single")) {
            put(taxRegistrationNumber, new SingleTaxpayer(fullname, taxRegistrationNumber, income));
        }
        else if (status.equals("Head of Household")) {
            put(taxRegistrationNumber, new HeadOfHouseholdTaxpayer(fullname, taxRegistrationNumber, income));
        }
        else {
            throw new WrongTaxpayerStatusException();
        }
    }
    
    public void createReceipt(int receiptId, String issueDate, float amount, String kind, String companyName, String country, String city, String street, int number, int taxRegistrationNumber) throws WrongReceiptKindException, WrongReceiptDateException {
        Receipt receipt = new Receipt(receiptId, issueDate, amount, kind, new Company(companyName, country, city, street, number));
        get_from_taxpayers(taxRegistrationNumber).addReceipt(receipt);
        put(receiptId, taxRegistrationNumber);
    }
    
    public String getTaxpayerStatus(int taxRegistrationNumber) {
        if(get_from_taxpayers(taxRegistrationNumber) instanceof MarriedFilingJointlyTaxpayer) {
            return "Married Filing Jointly";
        }
        else if(get_from_taxpayers(taxRegistrationNumber) instanceof MarriedFilingSeparatelyTaxpayer) {
            return "Married Filing Separately";
        }
        else if(get_from_taxpayers(taxRegistrationNumber) instanceof SingleTaxpayer) {
            return "Single";
        }
        else {
            return "Head of Household";
        }
    }

    public Taxpayer getTaxpayer(int taxRegistrationNumber) {
        return get_from_taxpayers(taxRegistrationNumber);
    }

    public String getTaxpayerName(int taxRegistrationNumber) {
        return get_from_taxpayers(taxRegistrationNumber).getFullname();
    }
    
    public String getTaxpayerIncome(int taxRegistrationNumber) {
        return "" + get_from_taxpayers(taxRegistrationNumber).getIncome();
    }
    
    public double getTaxpayerVariationTaxOnReceipts(int taxRegistrationNumber) {
        return get_from_taxpayers(taxRegistrationNumber).getVariationTaxOnReceipts();
    }

    public int getTaxpayerTotalReceiptsGathered(int taxRegistrationNumber) {
        return get_from_taxpayers(taxRegistrationNumber).getTotalReceiptsGathered();
    }
    
    public float getTaxpayerAmountOfReceiptKind(int taxRegistrationNumber, short kind) {
        return get_from_taxpayers(taxRegistrationNumber).getAmountOfReceiptKind(kind);
    }
    
    public double getTaxpayerTotalTax(int taxRegistrationNumber) {
        return get_from_taxpayers(taxRegistrationNumber).getTotalTax();
    }
    
    public double getTaxpayerBasicTax(int taxRegistrationNumber) {
        return get_from_taxpayers(taxRegistrationNumber).getBasicTax();
    }
    
    public HashMap<Integer, Receipt> getReceiptHashMap(int taxRegistrationNumber) {
        return get_from_taxpayers(taxRegistrationNumber).getReceiptHashMap();
    }
}
