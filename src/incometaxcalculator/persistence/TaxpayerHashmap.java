package incometaxcalculator.persistence;

import java.util.HashMap;

import incometaxcalculator.app.taxpayers.Taxpayer;

public class TaxpayerHashmap {
    private static HashMap<Integer, Taxpayer> self = new HashMap<Integer, Taxpayer>(0);

    public static Taxpayer get(int tax_registration_number) {
        return self.get(tax_registration_number);
    }

    public static void put(int tax_registration_number, Taxpayer new_taxpayer) {
        self.put(tax_registration_number, new_taxpayer);
    }

    public static void remove(int tax_registration_number) {
        self.remove(tax_registration_number);
    }

    public static boolean is_empty() {
        return self.isEmpty();
    }

    public static boolean contains(int tax_registration_number) {
        return self.containsKey(tax_registration_number);
    }

    public static int size() {
        return self.size();
    }

    public static void clear() {
        self.clear();
    }
}
