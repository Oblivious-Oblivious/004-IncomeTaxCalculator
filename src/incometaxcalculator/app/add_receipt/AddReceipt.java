package incometaxcalculator.app.add_receipt;

import java.io.IOException;

import incometaxcalculator.app.update_taxpayer_information.UpdateTaxpayerInformation;
import incometaxcalculator.boundaries.AddReceiptBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;
import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.Company;
import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class AddReceipt implements AddReceiptBoundary {
    // TODO Insert into file manager package
    private Receipt createReceipt(int receiptId, String issueDate, float amount, String kind, String companyName, String country, String city, String street, int number) throws WrongReceiptKindException, WrongReceiptDateException {
        return new Receipt(
            receiptId,
            issueDate,
            amount,
            kind,
            new Company(
                companyName,
                country,
                city,
                street,
                number
            )
        );
    }

    @Override
    public void add(int receiptId, String issueDate, float amount, String kind, String companyName, String country, String city, String street, int number, int taxRegistrationNumber) throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        Taxpayer current_taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);

        if(current_taxpayer.receiptHashMap.containsKey(receiptId))
            throw new ReceiptAlreadyExistsException();

        current_taxpayer.addReceipt(createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number));
        new UpdateTaxpayerInformation().update(taxRegistrationNumber);
    }
}
