package incometaxcalculator.boundaries;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import java.io.IOException;

public interface SaveDataBoundary {
    public void export(int tax_registration_number, String type) throws IOException, WrongFileFormatException;
}
