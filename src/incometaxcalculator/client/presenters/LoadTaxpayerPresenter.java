package incometaxcalculator.client.presenters;

import java.io.IOException;

import javax.swing.JOptionPane;

import incometaxcalculator.app.exceptions.WrongFileEndingException;
import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;
import incometaxcalculator.app.load_taxpayer.FileReaderType;
import incometaxcalculator.app.load_taxpayer.LoadTaxpayer;

public class LoadTaxpayerPresenter {
    public static void load(boolean type_is_txt, String taxRegistrationNumber) {
        FileReaderType type;
        if(type_is_txt)
            type = FileReaderType.TXT;
        else
            type = FileReaderType.XML;

        try {
            LoadTaxpayer loader = new LoadTaxpayer();

            int trn = Integer.parseInt(taxRegistrationNumber);
            if(loader.containsTaxpayer(trn))
                JOptionPane.showMessageDialog(null, "This taxpayer is already loaded.");
            else
                loader.load(trn, type);
        }
        catch(NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, "The tax registration number must have only digits.");
        }
        catch(IOException e1) {
            JOptionPane.showMessageDialog(null, "The file doesn't exists.");
        }
        catch(WrongFileFormatException e1) {
            JOptionPane.showMessageDialog(null, "Please check your file format and try again.");
        }
        catch(WrongFileEndingException e1) {
            JOptionPane.showMessageDialog(null, "Please check your file ending and try again.");
        }
        catch(WrongTaxpayerStatusException e1) {
            JOptionPane.showMessageDialog(null, "Please check taxpayer's status and try again.");
        }
        catch(WrongReceiptKindException e1) {
            JOptionPane.showMessageDialog(null, "Please check receipts kind and try again.");
        }
        catch(WrongReceiptDateException e1) {
            JOptionPane.showMessageDialog(null, "Please make sure your date is " + "DD/MM/YYYY and try again.");
        }
    }
}
