package incometaxcalculator.persistence;

import java.util.HashMap;

import incometaxcalculator.app.taxpayers.Taxpayer;

public class TaxpayerManager {
    public static HashMap<Integer, Taxpayer> taxpayerHashMap = new HashMap<Integer, Taxpayer>(0);
}
