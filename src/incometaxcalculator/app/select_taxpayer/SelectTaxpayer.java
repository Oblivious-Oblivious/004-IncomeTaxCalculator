package incometaxcalculator.app.select_taxpayer;

import javax.swing.JOptionPane;

import incometaxcalculator.boundaries.SelectTaxpayerBoundary;
import incometaxcalculator.client.gui.TaxpayerData;
import incometaxcalculator.data.management.TaxpayerManager;

public class SelectTaxpayer implements SelectTaxpayerBoundary {
    TaxpayerManager taxpayerManager;

    public SelectTaxpayer(TaxpayerManager taxpayerManager) {
        this.taxpayerManager = taxpayerManager;
    }

    @Override
    public void select() {
        if (taxpayerManager.containsTaxpayer()) {
            String trn = JOptionPane.showInputDialog(null, "Give the tax registration number " + "that you want to be displayed : ");
            if(trn != null) {
                try {
                    int taxRegistrationNumber = Integer.parseInt(trn);
                    if(taxpayerManager.containsTaxpayer(taxRegistrationNumber)) {
                        TaxpayerData taxpayerData = new TaxpayerData(taxRegistrationNumber, taxpayerManager);
                        taxpayerData.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "This tax registration number isn't loaded.");
                    }
                }
                catch(NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "You must give a tax registation number.");
                }
                catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "There isn't any taxpayer loaded. Please load one first.");
        }
    }
}
