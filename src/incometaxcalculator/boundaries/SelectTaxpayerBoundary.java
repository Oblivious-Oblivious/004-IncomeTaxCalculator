package incometaxcalculator.boundaries;

import incometaxcalculator.app.taxpayers.Taxpayer;

public interface SelectTaxpayerBoundary {
    public Taxpayer select(int tax_registration_number);
}
