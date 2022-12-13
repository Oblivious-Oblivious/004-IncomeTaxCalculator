package incometaxcalculator.boundaries;

import java.io.IOException;

import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.ReceiptKind;

public interface AddReceiptBoundary {
    public void add(int receipt_id, String date, float amount, ReceiptKind kind, String company_name, String country, String city, String street, int number, int tax_registration_number) throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException;
}
