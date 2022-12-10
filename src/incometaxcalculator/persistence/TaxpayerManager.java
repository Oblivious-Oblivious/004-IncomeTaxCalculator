package incometaxcalculator.persistence;

import java.util.HashMap;

import incometaxcalculator.app.taxpayers.Taxpayer;

public class TaxpayerManager {
    public static HashMap<Integer, Taxpayer> taxpayerHashMap = new HashMap<Integer, Taxpayer>(0);
    public static HashMap<Integer, Integer> receiptOwnerTRN = new HashMap<Integer, Integer>(0);

    // public static Taxpayer getTaxpayer(int taxRegistrationNumber) {
    //     return taxpayerHashMap.get(taxRegistrationNumber);
    // }
}
