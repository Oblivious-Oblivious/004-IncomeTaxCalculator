package incometaxcalculator.app.delete_taxpayer;

import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class DeleteTaxpayer implements DeleteTaxpayerBoundary {
    @Override
    public void delete(int tax_registration_number) {
        TaxpayerHashmap.remove(tax_registration_number);
    }

    @Override
    public boolean taxpayer_hashmap_is_not_empty() {
        return !TaxpayerHashmap.is_empty();
    }

    @Override
    public boolean contains_taxpayer(int tax_registration_number) {
        return TaxpayerHashmap.contains(tax_registration_number);
    }
}
