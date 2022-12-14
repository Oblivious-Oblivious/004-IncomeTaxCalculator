package incometaxcalculator.app.update_taxpayer_information;

import java.io.File;
import java.io.IOException;

import incometaxcalculator.boundaries.UpdateTaxpayerInformationBoundary;

public class UpdateTaxpayerInformation implements UpdateTaxpayerInformationBoundary {
    @Override
    public void update(int tax_registration_number) throws IOException {
        if(new File(tax_registration_number + "_INFO.xml").exists()) {
            InfoWriter writer = new XMLInfoWriter(tax_registration_number);
            writer.write_info();
        }
        if(new File(tax_registration_number + "_INFO.xml").exists()) {
            InfoWriter writer = new TXTInfoWriter(tax_registration_number);
            writer.write_info();
        }
    }
}
