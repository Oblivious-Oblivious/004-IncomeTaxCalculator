package incometaxcalculator.app.delete_receipt;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.boundaries.DeleteReceiptBoundary;
import incometaxcalculator.persistence.TaxpayerManager;
import incometaxcalculator.app.update_taxpayer_information.UpdateTaxpayerInformation;

public class DeleteReceipt implements DeleteReceiptBoundary {
    @Override
    public void delete(int receipt_id) throws IOException, WrongReceiptKindException {
        // this.manager.taxpayerHashMap.get(this.manager.get_from_receipts(receipt_id)).removeReceipt(receipt_id);
        TaxpayerManager.taxpayerHashMap.get(TaxpayerManager.receiptOwnerTRN.get(receipt_id)).removeReceipt(receipt_id);
        // updateFiles(this.manager.get_from_receipts(receipt_id));
        new UpdateTaxpayerInformation().update(TaxpayerManager.receiptOwnerTRN.get(receipt_id));
        // this.manager.remove_from_receipts(receipt_id);
        TaxpayerManager.receiptOwnerTRN.remove(receipt_id);
    }
}
