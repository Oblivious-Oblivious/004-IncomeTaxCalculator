package incometaxcalculator.app.load_taxpayer;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileEndingException;
import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;
import incometaxcalculator.boundaries.LoadTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class LoadTaxpayer implements LoadTaxpayerBoundary {
    @Override
    public void load(int tax_registration_number, FileReaderType type) throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
        FileReader reader = FileReaderFactory.create(type);
        String filename = tax_registration_number + "_INFO." + type;
        reader.read_file(filename);
    }

    @Override
    public boolean contains_taxpayer(int tax_registration_number) {
        return TaxpayerHashmap.contains(tax_registration_number);
    }
}
