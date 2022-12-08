package incometaxcalculator.app.add_receipt;

import java.io.File;
import java.io.IOException;

import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.boundaries.AddReceiptBoundary;
import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.io.XMLInfoWriter;
import incometaxcalculator.data.management.Company;
import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public class AddReceipt implements AddReceiptBoundary {
    TaxpayerManager manager;

    public AddReceipt(TaxpayerManager manager) {
        this.manager = manager;
    }

    // TODO Insert into file manager package
    private void updateFiles(int taxRegistrationNumber) throws IOException {
        if(new File(taxRegistrationNumber + "_INFO.xml").exists()) {
            new XMLInfoWriter().generateFile(taxRegistrationNumber);
        }
        else {
            new TXTInfoWriter().generateFile(taxRegistrationNumber);
            return;
        }
        
        if(new File(taxRegistrationNumber + "_INFO.txt").exists()) {
            new TXTInfoWriter().generateFile(taxRegistrationNumber);
        }
    }

    // TODO Insert into file manager package
    private void createReceipt(int receiptId, String issueDate, float amount, String kind, String companyName, String country, String city, String street, int number, int taxRegistrationNumber) throws WrongReceiptKindException, WrongReceiptDateException {
        Receipt receipt = new Receipt(receiptId, issueDate, amount, kind, new Company(companyName, country, city, street, number));
        this.manager.get_from_taxpayers(taxRegistrationNumber).addReceipt(receipt);
        this.manager.put(receiptId, taxRegistrationNumber);
    }

    @Override
    public void add(int receiptId, String issueDate, float amount, String kind, String companyName, String country, String city, String street, int number, int taxRegistrationNumber) throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        if(this.manager.containsReceipt(receiptId)) {
            throw new ReceiptAlreadyExistsException();
        }
        
        createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
        updateFiles(taxRegistrationNumber);
    }
}
