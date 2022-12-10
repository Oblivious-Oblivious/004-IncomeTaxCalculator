package incometaxcalculator.persistence;

import java.util.HashMap;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.MarriedFilingJointlyTaxpayer;
import incometaxcalculator.app.taxpayers.MarriedFilingSeparatelyTaxpayer;
import incometaxcalculator.app.taxpayers.SingleTaxpayer;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class TaxpayerManager {
    public static HashMap<Integer, Taxpayer> taxpayerHashMap = new HashMap<Integer, Taxpayer>(0);
    public static HashMap<Integer, Integer> receiptOwnerTRN = new HashMap<Integer, Integer>(0);

    public static boolean containsTaxpayer(int taxRegistrationNumber) {
        return taxpayerHashMap.containsKey(taxRegistrationNumber);
    }

    public static boolean taxpayer_hashmap_is_not_empty() {
        return !taxpayerHashMap.isEmpty();
    }

    public static boolean containsReceipt(int id) {
        return receiptOwnerTRN.containsKey(id);
    }

    public static String getTaxpayerStatus(int taxRegistrationNumber) {
        if(taxpayerHashMap.get(taxRegistrationNumber) instanceof MarriedFilingJointlyTaxpayer)
            return "Married Filing Jointly";
        else if(taxpayerHashMap.get(taxRegistrationNumber) instanceof MarriedFilingSeparatelyTaxpayer)
            return "Married Filing Separately";
        else if(taxpayerHashMap.get(taxRegistrationNumber) instanceof SingleTaxpayer)
            return "Single";
        else
            return "Head of Household";
    }

    public static Taxpayer getTaxpayer(int taxRegistrationNumber) {
        return taxpayerHashMap.get(taxRegistrationNumber);
    }

    public static String getTaxpayerName(int taxRegistrationNumber) {
        return taxpayerHashMap.get(taxRegistrationNumber).getFullname();
    }

    public static String getTaxpayerIncome(int taxRegistrationNumber) {
        return "" + taxpayerHashMap.get(taxRegistrationNumber).getIncome();
    }

    public static double getTaxpayerVariationTaxOnReceipts(int taxRegistrationNumber) {
        return taxpayerHashMap.get(taxRegistrationNumber).getVariationTaxOnReceipts();
    }

    public static int getTaxpayerTotalReceiptsGathered(int taxRegistrationNumber) {
        return taxpayerHashMap.get(taxRegistrationNumber).getTotalReceiptsGathered();
    }

    public static float getTaxpayerAmountOfReceiptKind(int taxRegistrationNumber, short kind) {
        return taxpayerHashMap.get(taxRegistrationNumber).getAmountOfReceiptKind(kind);
    }

    public static double getTaxpayerTotalTax(int taxRegistrationNumber) {
        return taxpayerHashMap.get(taxRegistrationNumber).getTotalTax();
    }

    public static double getTaxpayerBasicTax(int taxRegistrationNumber) {
        return taxpayerHashMap.get(taxRegistrationNumber).getBasicTax();
    }

    public static HashMap<Integer, Receipt> getReceiptHashMap(int taxRegistrationNumber) {
        return taxpayerHashMap.get(taxRegistrationNumber).getReceiptHashMap();
    }
}
