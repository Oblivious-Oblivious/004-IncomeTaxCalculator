package incometaxcalculator.app.save_data;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.boundaries.SaveDataBoundary;

public class SaveData implements SaveDataBoundary {
    @Override
    public void export(int tax_registration_number, LogWriterType type) throws IOException, WrongFileFormatException {
        LogWriter writer = LogWriterFactory.create(type, tax_registration_number);
        writer.write_log();
    }
}
