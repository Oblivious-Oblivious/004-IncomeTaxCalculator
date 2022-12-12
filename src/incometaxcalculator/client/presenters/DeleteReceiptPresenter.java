package incometaxcalculator.client.presenters;

import java.io.IOException;

import javax.swing.JOptionPane;

import incometaxcalculator.app.delete_receipt.DeleteReceipt;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;

public class DeleteReceiptPresenter {
    public static int delete(String receipt_id_value, int tax_registration_number) {
        int receipt_id = Integer.parseInt(receipt_id_value);

        try {
            new DeleteReceipt().delete(tax_registration_number, receipt_id);
        }
        catch(IOException e1) {
            JOptionPane.showMessageDialog(null, "Problem with opening file ." + receipt_id + "_INFO.txt");
        }
        catch(WrongReceiptKindException e1) {
            JOptionPane.showMessageDialog(null, "Please check receipt's kind and try again.");
        }

        return receipt_id;
    }
}
