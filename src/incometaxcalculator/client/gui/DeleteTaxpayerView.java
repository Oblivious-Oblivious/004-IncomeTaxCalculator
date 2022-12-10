package incometaxcalculator.client.gui;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import incometaxcalculator.app.delete_taxpayer.DeleteTaxpayer;

// TODO Try refactor out
import incometaxcalculator.persistence.TaxpayerManager;

public class DeleteTaxpayerView {
    DefaultListModel<String> taxRegisterNumberModel;

    public DeleteTaxpayerView(DefaultListModel<String> taxRegisterNumberModel) {
        this.taxRegisterNumberModel = taxRegisterNumberModel;
    }

    public void delete() {
        if(TaxpayerManager.taxpayer_hashmap_is_not_empty()) {
            String trn = JOptionPane.showInputDialog(null, "Give the tax registration number that you want to delete: ");
            try {
                int taxRegistrationNumber = Integer.parseInt(trn);
                if(TaxpayerManager.containsTaxpayer(taxRegistrationNumber)) {
                    new DeleteTaxpayer().delete(taxRegistrationNumber);
                    taxRegisterNumberModel.removeElement(trn);
                }
            }
            catch (NumberFormatException e) {
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "There isn't any taxpayer loaded. Please load one first.");
        }
    }
}
