package incometaxcalculator.client.presenters;

import java.io.IOException;

import javax.swing.JOptionPane;

import incometaxcalculator.app.add_receipt.AddReceipt;
import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.ReceiptKind;

public class AddReceiptPresenter {
    public static int add(String receipt_id_value, String date, String amount_value, String kind_value, String company_name, String country, String city, String street, String number_value, int tax_registration_number) {
        int receipt_id = Integer.parseInt(receipt_id_value);
        float amount = Float.parseFloat(amount_value);
        ReceiptKind kind = ReceiptKind.from_string(kind_value);
        int number = Integer.parseInt(number_value);

        try {
            new AddReceipt().add(receipt_id, date, amount, kind, company_name, country, city, street, number, tax_registration_number);
        }

        // TODO Only return error messages, remove JOptionPanes
        catch(IOException e1) {
            JOptionPane.showMessageDialog(null, "Problem with opening file ." + receipt_id + "_INFO.txt");
        }
        catch(WrongReceiptKindException e1) {
            JOptionPane.showMessageDialog(null, "Please check receipts kind and try again.");
        }
        catch(WrongReceiptDateException e1) {
            JOptionPane.showMessageDialog(null, "Please make sure your date " + "is DD/MM/YYYY and try again.");
        }
        catch(ReceiptAlreadyExistsException e1) {
            JOptionPane.showMessageDialog(null, "Receipt ID already exists.");
        }

        return receipt_id;
    }
}
