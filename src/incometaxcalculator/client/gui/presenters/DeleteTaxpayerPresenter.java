package incometaxcalculator.client.gui.presenters;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import incometaxcalculator.app.delete_taxpayer.DeleteTaxpayer;

public class DeleteTaxpayerPresenter {
    DefaultListModel<String> taxRegisterNumberModel;

    public DeleteTaxpayerPresenter(DefaultListModel<String> taxRegisterNumberModel) {
        this.taxRegisterNumberModel = taxRegisterNumberModel;
    }

    public void delete() {
        DeleteTaxpayer deleter = new DeleteTaxpayer();

        if(deleter.taxpayer_hashmap_is_not_empty()) {
            String trn = JOptionPane.showInputDialog(null, "Give the tax registration number that you want to delete: ");
            try {
                int taxRegistrationNumber = Integer.parseInt(trn);
                if(deleter.containsTaxpayer(taxRegistrationNumber)) {
                    deleter.delete(taxRegistrationNumber);
                    taxRegisterNumberModel.removeElement(trn);
                }
            }
            catch(NumberFormatException e) {
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "There isn't any taxpayer loaded. Please load one first.");
        }
    }
}