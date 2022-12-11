package incometaxcalculator.app.save_data;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.boundaries.SaveDataBoundary;

public class SaveData implements SaveDataBoundary {
    @Override
    public void export(int tax_registration_number, String type) throws IOException, WrongFileFormatException {
        // TODO Get from factory
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
