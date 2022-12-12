package incometaxcalculator.client.presenters;

import java.io.IOException;

import javax.swing.JOptionPane;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.save_data.LogWriterType;
import incometaxcalculator.app.save_data.SaveData;

public class SaveDataPresenter {
    public static void save(boolean is_type_txt, int tax_registration_number) {
        try {
            try {
                if(is_type_txt) {
                    new SaveData().export(tax_registration_number, LogWriterType.TXT);
                }
                else {
                    new SaveData().export(tax_registration_number, LogWriterType.XML);
                }
            }
            catch(IOException e1) {
                JOptionPane.showMessageDialog(null, "Problem with opening file ." + tax_registration_number + "_LOG.xml");
            }
            catch(WrongFileFormatException e1) {
                JOptionPane.showMessageDialog(null, "Wrong file format");
            }
        }
        catch(NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, "The tax registration number must have only digits.");
        }
    }
}
