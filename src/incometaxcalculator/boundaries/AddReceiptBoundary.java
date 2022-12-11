package incometaxcalculator.boundaries;

import java.io.IOException;

import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.ReceiptKind;

public interface AddReceiptBoundary {
    public void add(int receiptId, String issueDate, float amount, ReceiptKind kind, String companyName, String country, String city, String street, int number, int taxRegistrationNumber) throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException;
}
