package incometaxcalculator.app.select_taxpayer;

// import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.SelectTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class SelectTaxpayer implements SelectTaxpayerBoundary {
    // Taxpayer current_taxpayer;

    @Override
    // public void select(int tax_registration_number) {
    public void select() {
        // this.current_taxpayer = TaxpayerManager.taxpayerHashMap.get(tax_registration_number);
    }

    // TODO Eventually perform all calculation here
    public boolean taxpayer_hashmap_is_not_empty() {
        return !TaxpayerHashmap.is_empty();
    }

    public boolean containsTaxpayer(int taxRegistrationNumber) {
        return TaxpayerHashmap.contains(taxRegistrationNumber);
    }
}
