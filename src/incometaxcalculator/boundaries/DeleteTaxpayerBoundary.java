package incometaxcalculator.boundaries;

public interface DeleteTaxpayerBoundary {
    public void delete(int tax_registration_number);
    public boolean taxpayer_hashmap_is_not_empty();
    public boolean contains_taxpayer(int tax_registration_number);
}
