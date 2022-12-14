package incometaxcalculator.client.presenters;

import java.io.IOException;

import incometaxcalculator.app.delete_receipt.DeleteReceipt;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.boundaries.DeleteReceiptBoundary;
import incometaxcalculator.client.gui.helpers.Pair;

public class DeleteReceiptPresenter {
    public static Pair<Integer, String> delete(String receipt_id_value, int tax_registration_number) {
        int receipt_id = Integer.parseInt(receipt_id_value);

        try {
            DeleteReceiptBoundary deleter = new DeleteReceipt();
            deleter.delete(tax_registration_number, receipt_id);
        }
        catch(IOException e1) {
            return new Pair<Integer, String>(-1, "Problem with opening file ." + receipt_id + "_INFO.txt");
        }
        catch(WrongReceiptKindException e1) {
            return new Pair<Integer, String>(-1, "Please check receipt's kind and try again.");
        }

        return new Pair<Integer, String>(receipt_id, "");
    }
}
