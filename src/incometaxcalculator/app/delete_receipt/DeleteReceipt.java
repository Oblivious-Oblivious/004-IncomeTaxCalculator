package incometaxcalculator.app.delete_receipt;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.DeleteReceiptBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;
import incometaxcalculator.app.update_taxpayer_information.UpdateTaxpayerInformation;

public class DeleteReceipt implements DeleteReceiptBoundary {
    @Override
    public void delete(int tax_registration_number, int receipt_id) throws IOException, WrongReceiptKindException {
        Taxpayer current_taxpayer = TaxpayerHashmap.get(tax_registration_number);
        current_taxpayer.remove_receipt(receipt_id);
        new UpdateTaxpayerInformation().update(tax_registration_number);
    }
}
