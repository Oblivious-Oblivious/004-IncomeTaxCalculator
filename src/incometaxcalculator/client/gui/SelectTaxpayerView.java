package incometaxcalculator.client.gui;

import javax.swing.JOptionPane;

import incometaxcalculator.app.select_taxpayer.SelectTaxpayer;

public class SelectTaxpayerView {
    public void select() {
        SelectTaxpayer selector = new SelectTaxpayer();

        if(selector.taxpayer_hashmap_is_not_empty()) {
            String trn = JOptionPane.showInputDialog(null, "Give the tax registration number " + "that you want to be displayed : ");
            if(trn != null) {
                try {
                    int taxRegistrationNumber = Integer.parseInt(trn);
                    if(selector.containsTaxpayer(taxRegistrationNumber)) {
                        TaxpayerData taxpayerData = new TaxpayerData(taxRegistrationNumber);
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
