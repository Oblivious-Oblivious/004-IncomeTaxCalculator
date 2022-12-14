package incometaxcalculator.client.presenters;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileEndingException;
import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;
import incometaxcalculator.app.load_taxpayer.FileReaderType;
import incometaxcalculator.app.load_taxpayer.LoadTaxpayer;
import incometaxcalculator.boundaries.LoadTaxpayerBoundary;

public class LoadTaxpayerPresenter {
    public static String load(boolean type_is_txt, String taxRegistrationNumber) {
        FileReaderType type;
        if(type_is_txt)
            type = FileReaderType.TXT;
        else
            type = FileReaderType.XML;

        try {
            LoadTaxpayerBoundary loader = new LoadTaxpayer();

            int trn = Integer.parseInt(taxRegistrationNumber);
            if(loader.contains_taxpayer(trn))
                return "This taxpayer is already loaded.";
            else
                loader.load(trn, type);

            return "";
        }
        catch(NumberFormatException e1) {
            return "The tax registration number must have only digits.";
        }
        catch(IOException e1) {
            return "The file does not exist.";
        }
        catch(WrongFileFormatException e1) {
            return "Please check your file format and try again.";
        }
        catch(WrongFileEndingException e1) {
            return "Please check your file ending and try again.";
        }
        catch(WrongTaxpayerStatusException e1) {
            return "Please check taxpayer's status and try again.";
        }
        catch(WrongReceiptKindException e1) {
            return "Please check receipts kind and try again.";
        }
        catch(WrongReceiptDateException e1) {
            return "Please make sure your date is " + "DD/MM/YYYY and try again.";
        }
    }
}
