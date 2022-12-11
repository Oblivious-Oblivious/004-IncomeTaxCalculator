package incometaxcalculator.app.delete_taxpayer;

import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerManager;

public class DeleteTaxpayer implements DeleteTaxpayerBoundary {
    @Override
    public void delete(int tax_registration_number) {
        TaxpayerManager.taxpayerHashMap.remove(tax_registration_number);
    }

    public boolean taxpayer_hashmap_is_not_empty() {
        return !TaxpayerManager.taxpayerHashMap.isEmpty();
    }

    public boolean containsTaxpayer(int taxRegistrationNumber) {
        return TaxpayerManager.taxpayerHashMap.containsKey(taxRegistrationNumber);
    }
}
