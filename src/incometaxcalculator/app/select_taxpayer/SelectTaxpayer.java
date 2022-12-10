package incometaxcalculator.app.select_taxpayer;

// import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.SelectTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerManager;

public class SelectTaxpayer implements SelectTaxpayerBoundary {
    // Taxpayer current_taxpayer;

    @Override
    // public void select(int tax_registration_number) {
    public void select() {
        // this.current_taxpayer = TaxpayerManager.taxpayerHashMap.get(tax_registration_number);
    }

    public boolean taxpayer_hashmap_is_not_empty() {
        return !TaxpayerManager.taxpayerHashMap.isEmpty();
    }

    public boolean containsTaxpayer(int taxRegistrationNumber) {
        return TaxpayerManager.taxpayerHashMap.containsKey(taxRegistrationNumber);
    }
}
