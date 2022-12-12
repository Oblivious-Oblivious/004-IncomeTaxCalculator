package incometaxcalculator.client.presenters;

import javax.swing.JOptionPane;

import incometaxcalculator.app.delete_taxpayer.DeleteTaxpayer;

public class DeleteTaxpayerPresenter {
    public static void delete(String trn) {
        int tax_registration_number = Integer.parseInt(trn);

        DeleteTaxpayer deleter = new DeleteTaxpayer();
        if(deleter.taxpayer_hashmap_is_not_empty()) {
            try {
                if(deleter.containsTaxpayer(tax_registration_number))
                    deleter.delete(tax_registration_number);
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Adress number is not a valid number.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "There isn't any taxpayer loaded. Please load one first.");
        }
    }
}
