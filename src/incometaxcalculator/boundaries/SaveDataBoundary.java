package incometaxcalculator.boundaries;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.save_data.LogWriterType;

import java.io.IOException;

public interface SaveDataBoundary {
    public void export(int tax_registration_number, LogWriterType type) throws IOException, WrongFileFormatException;
}
