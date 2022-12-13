package incometaxcalculator.app.select_taxpayer;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.SelectTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class SelectTaxpayer implements SelectTaxpayerBoundary {
    @Override
    public Taxpayer select(int tax_registration_number) {
        return TaxpayerHashmap.get(tax_registration_number);
    }

    public boolean taxpayer_hashmap_is_not_empty() {
        return !TaxpayerHashmap.is_empty();
    }

    public boolean contains_taxpayer(int tax_registration_number) {
        return TaxpayerHashmap.contains(tax_registration_number);
    }
}
