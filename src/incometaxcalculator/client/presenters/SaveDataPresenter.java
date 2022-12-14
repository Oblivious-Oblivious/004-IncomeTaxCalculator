package incometaxcalculator.client.presenters;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.save_data.LogWriterType;
import incometaxcalculator.app.save_data.SaveData;
import incometaxcalculator.boundaries.SaveDataBoundary;

public class SaveDataPresenter {
    public static String save(boolean is_type_txt, int tax_registration_number) {
        try {
            SaveDataBoundary saver = new SaveData();
            if(is_type_txt) {
                saver.export(tax_registration_number, LogWriterType.TXT);
                return "";
            }
            else {
                saver.export(tax_registration_number, LogWriterType.XML);
                return "";
            }
        }
        catch(IOException e1) {
            return "Problem with opening file ." + tax_registration_number + "_LOG.xml";
        }
        catch(WrongFileFormatException e1) {
            return "Wrong file format";
        }
        catch(NumberFormatException e1) {
            return "The tax registration number must have only digits.";
        }
    }
}
