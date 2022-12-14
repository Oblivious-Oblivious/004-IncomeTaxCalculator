package incometaxcalculator.boundaries;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileEndingException;
import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;
import incometaxcalculator.app.load_taxpayer.FileReaderType;

public interface LoadTaxpayerBoundary {
    public void load(int tax_registration_number, FileReaderType type) throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException;
    public boolean contains_taxpayer(int tax_registration_number);
}
