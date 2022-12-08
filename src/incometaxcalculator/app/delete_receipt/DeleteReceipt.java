package incometaxcalculator.app.delete_receipt;

import java.io.File;
import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.boundaries.DeleteReceiptBoundary;
import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.io.XMLInfoWriter;
import incometaxcalculator.data.management.TaxpayerManager;

public class DeleteReceipt implements DeleteReceiptBoundary {
    TaxpayerManager manager;

    public DeleteReceipt(TaxpayerManager manager) {
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

    @Override
    public void delete(int receipt_id) throws IOException, WrongReceiptKindException {
        this.manager.get_from_taxpayers(this.manager.get_from_receipts(receipt_id)).removeReceipt(receipt_id);
        updateFiles(this.manager.get_from_receipts(receipt_id));
        this.manager.remove_from_receipts(receipt_id);
    }
}
