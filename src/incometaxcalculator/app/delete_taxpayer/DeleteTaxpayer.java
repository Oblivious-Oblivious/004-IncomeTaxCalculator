package incometaxcalculator.app.delete_taxpayer;

import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class DeleteTaxpayer implements DeleteTaxpayerBoundary {
    @Override
    public void delete(int tax_registration_number) {
        TaxpayerHashmap.remove(tax_registration_number);
    }

    // TODO Eventually try removing
    public boolean taxpayer_hashmap_is_not_empty() {
        return !TaxpayerHashmap.is_empty();
    }

    public boolean containsTaxpayer(int taxRegistrationNumber) {
        return TaxpayerHashmap.contains(taxRegistrationNumber);
    }
}
