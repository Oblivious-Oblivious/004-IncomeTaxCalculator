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
    public void load(int tax_registration_number, String type) throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
        String filename = tax_registration_number + "_INFO." + type;
        // TODO Factory of types
        if(type.equals("txt")) {
            FileReader reader = new TXTFileReader();
            reader.readFile(filename);
        }
        else if(type.equals("xml")) {
            FileReader reader = new XMLFileReader();
            reader.readFile(filename);
        }
        else {
            throw new WrongFileEndingException();
        }
    }

    // TODO Eventually try remove
    public boolean containsTaxpayer(int taxRegistrationNumber) {
        return TaxpayerHashmap.contains(taxRegistrationNumber);
    }
}
