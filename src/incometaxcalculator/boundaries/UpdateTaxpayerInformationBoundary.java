package incometaxcalculator.boundaries;

import java.io.IOException;

public interface UpdateTaxpayerInformationBoundary {
    public void update(int tax_registration_number) throws IOException;
}
