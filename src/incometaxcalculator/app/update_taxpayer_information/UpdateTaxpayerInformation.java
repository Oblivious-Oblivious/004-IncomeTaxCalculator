package incometaxcalculator.app.update_taxpayer_information;

import java.io.File;
import java.io.IOException;

import incometaxcalculator.boundaries.UpdateTaxpayerInformationBoundary;

public class UpdateTaxpayerInformation implements UpdateTaxpayerInformationBoundary {
    @Override
    public void update(int tax_registration_number) throws IOException {
        if(new File(tax_registration_number + "_INFO.xml").exists()) {
            new XMLInfoWriter().generateFile(tax_registration_number);
        }
        else {
            new TXTInfoWriter().generateFile(tax_registration_number);
            return;
        }

        if(new File(tax_registration_number + "_INFO.txt").exists()) {
            new TXTInfoWriter().generateFile(tax_registration_number);
        }
    }
}
