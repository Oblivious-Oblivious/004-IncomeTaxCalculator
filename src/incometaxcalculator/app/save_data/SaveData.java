package incometaxcalculator.app.save_data;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.boundaries.SaveDataBoundary;
import incometaxcalculator.data.io.TXTLogWriter;
import incometaxcalculator.data.io.XMLLogWriter;
import incometaxcalculator.data.management.TaxpayerManager;

public class SaveData implements SaveDataBoundary {
    TaxpayerManager manager;

    public SaveData(TaxpayerManager manager) {
        this.manager = manager;
    }

    @Override
    public void export(int tax_registration_number, String type) throws IOException, WrongFileFormatException {
        if(type.equals("txt")) {
            TXTLogWriter writer = new TXTLogWriter();
            writer.generateFile(tax_registration_number);
        }
        else if(type.equals("xml")) {
            XMLLogWriter writer = new XMLLogWriter();
            writer.generateFile(tax_registration_number);
        }
        else {
            throw new WrongFileFormatException();
        }
    }
}
