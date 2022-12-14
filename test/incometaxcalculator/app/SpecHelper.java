package incometaxcalculator.app;

import incometaxcalculator.app.taxpayers.HeadOfHouseholdTaxpayer;
import incometaxcalculator.app.taxpayers.MarriedFilingJointlyTaxpayer;
import incometaxcalculator.app.taxpayers.MarriedFilingSeparatelyTaxpayer;
import incometaxcalculator.app.taxpayers.SingleTaxpayer;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class SpecHelper {
    public static void clear_taxpayer_hashmap() {
        TaxpayerHashmap.clear();
    }

    public static void setup_taxpayer_hashmap() {
        TaxpayerHashmap.put(100000000, new SingleTaxpayer("dummy0", 100000000, 120000));
        TaxpayerHashmap.put(100000001, new SingleTaxpayer("dummy1", 100000001, 120000));
        TaxpayerHashmap.put(100000002, new HeadOfHouseholdTaxpayer("dummy2", 100000002, 120000));
        TaxpayerHashmap.put(100000003, new HeadOfHouseholdTaxpayer("dummy3", 100000003, 120000));
        TaxpayerHashmap.put(100000004, new MarriedFilingSeparatelyTaxpayer("dummy4", 100000004, 120000));
        TaxpayerHashmap.put(100000005, new MarriedFilingSeparatelyTaxpayer("dummy5", 100000005, 120000));
        TaxpayerHashmap.put(100000006, new MarriedFilingJointlyTaxpayer("dummy6", 100000006, 120000));
        TaxpayerHashmap.put(100000007, new MarriedFilingJointlyTaxpayer("dummy7", 100000007, 120000));
    }
}
