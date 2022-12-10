package incometaxcalculator.app.delete_receipt;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.boundaries.DeleteReceiptBoundary;
import incometaxcalculator.persistence.TaxpayerManager;
import incometaxcalculator.app.update_taxpayer_information.UpdateTaxpayerInformation;

public class DeleteReceipt implements DeleteReceiptBoundary {
    @Override
    public void delete(int receipt_id) throws IOException, WrongReceiptKindException {
        TaxpayerManager.taxpayerHashMap.get(TaxpayerManager.receiptOwnerTRN.get(receipt_id)).removeReceipt(receipt_id);
        new UpdateTaxpayerInformation().update(TaxpayerManager.receiptOwnerTRN.get(receipt_id));
        TaxpayerManager.receiptOwnerTRN.remove(receipt_id);
    }
}
