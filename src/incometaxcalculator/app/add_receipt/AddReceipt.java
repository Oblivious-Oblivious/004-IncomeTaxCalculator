package incometaxcalculator.app.add_receipt;

import java.io.IOException;

import incometaxcalculator.app.update_taxpayer_information.UpdateTaxpayerInformation;
import incometaxcalculator.boundaries.AddReceiptBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;
import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class AddReceipt implements AddReceiptBoundary {
    @Override
    public void add(int receipt_id, String date, float amount, ReceiptKind kind, String company_name, String country, String city, String street, int number, int tax_registration_number) throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        Taxpayer current_taxpayer = TaxpayerHashmap.get(tax_registration_number);

        if(current_taxpayer.contains(receipt_id))
            throw new ReceiptAlreadyExistsException();

        current_taxpayer.add_receipt(new Receipt(receipt_id, date, amount, kind, company_name, country, city, street, number));
        new UpdateTaxpayerInformation().update(tax_registration_number);
    }
}
