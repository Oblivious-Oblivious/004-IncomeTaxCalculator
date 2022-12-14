package incometaxcalculator.client.presenters;

import java.io.IOException;

import incometaxcalculator.app.add_receipt.AddReceipt;
import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.boundaries.AddReceiptBoundary;
import incometaxcalculator.client.gui.helpers.Pair;

public class AddReceiptPresenter {
    public static Pair<Integer, String> add(String receipt_id_value, String date, String amount_value, String kind_value, String company_name, String country, String city, String street, String number_value, int tax_registration_number) {
        int receipt_id = -1;

        try {
            receipt_id = Integer.parseInt(receipt_id_value);
            float amount = Float.parseFloat(amount_value);
            int number = Integer.parseInt(number_value);
            ReceiptKind kind = ReceiptKind.from_string(kind_value);

            AddReceiptBoundary adder = new AddReceipt();
            adder.add(receipt_id, date, amount, kind, company_name, country, city, street, number, tax_registration_number);
        }

        catch(IOException e1) {
            return new Pair<Integer, String>(-1, "Problem with opening file ." + receipt_id + "_INFO.txt");
        }
        catch(WrongReceiptKindException e1) {
            return new Pair<Integer, String>(-1, "Please check receipts kind and try again.");
        }
        catch(WrongReceiptDateException e1) {
            return new Pair<Integer, String>(-1, "Please make sure your date " + "is DD/MM/YYYY and try again.");
        }
        catch(ReceiptAlreadyExistsException e1) {
            return new Pair<Integer, String>(-1, "Receipt ID already exists.");
        }

        return new Pair<Integer, String>(receipt_id, "");
    }
}
