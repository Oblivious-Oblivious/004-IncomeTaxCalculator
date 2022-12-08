package incometaxcalculator.delete_taxpayer;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;
import incometaxcalculator.data.management.TaxpayerManager;

public class DeleteTaxpayer implements DeleteTaxpayerBoundary {
    TaxpayerManager taxpayerManager;
    DefaultListModel<String> taxRegisterNumberModel;

    public DeleteTaxpayer(TaxpayerManager taxpayerManager, DefaultListModel<String> taxRegisterNumberModel) {
        this.taxpayerManager = taxpayerManager;
        this.taxRegisterNumberModel = taxRegisterNumberModel;
    }

    @Override
    public void delete() {
        if(taxpayerManager.containsTaxpayer()) {
            String trn = JOptionPane.showInputDialog(null, "Give the tax registration number that you want to delete: ");
            try {
                int taxRegistrationNumber = Integer.parseInt(trn);
                if(taxpayerManager.containsTaxpayer(taxRegistrationNumber)) {
                    taxpayerManager.removeTaxpayer(taxRegistrationNumber);
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
