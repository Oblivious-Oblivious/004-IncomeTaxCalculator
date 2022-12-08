package incometaxcalculator.client.gui;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import incometaxcalculator.app.delete_taxpayer.DeleteTaxpayer;
import incometaxcalculator.data.management.TaxpayerManager;

public class DeleteTaxpayerView {
    TaxpayerManager taxpayerManager;
    DefaultListModel<String> taxRegisterNumberModel;

    public DeleteTaxpayerView(TaxpayerManager taxpayerManager, DefaultListModel<String> taxRegisterNumberModel) {
        this.taxpayerManager = taxpayerManager;
        this.taxRegisterNumberModel = taxRegisterNumberModel;
    }

    public void delete() {
        if(taxpayerManager.containsTaxpayer()) {
            String trn = JOptionPane.showInputDialog(null, "Give the tax registration number that you want to delete: ");
            try {
                int taxRegistrationNumber = Integer.parseInt(trn);
                if(taxpayerManager.containsTaxpayer(taxRegistrationNumber)) {
                    new DeleteTaxpayer(taxpayerManager).delete(taxRegistrationNumber);
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
