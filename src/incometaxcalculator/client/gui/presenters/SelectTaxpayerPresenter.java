package incometaxcalculator.client.gui.presenters;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import incometaxcalculator.app.select_taxpayer.SelectTaxpayer;
import incometaxcalculator.client.gui.views.TaxpayerDataView;

public class SelectTaxpayerPresenter {
    public static void select(JPanel contentPane) {
        JButton btnSelectTaxpayer = new JButton("Select Taxpayer");
        btnSelectTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectTaxpayer selector = new SelectTaxpayer();

                if(selector.taxpayer_hashmap_is_not_empty()) {
                    String trn = JOptionPane.showInputDialog(null, "Give the tax registration number " + "that you want to be displayed : ");
                    if(trn != null) {
                        try {
                            int taxRegistrationNumber = Integer.parseInt(trn);
                            if(selector.containsTaxpayer(taxRegistrationNumber)) {
                                TaxpayerDataView taxpayerData = new TaxpayerDataView(selector.select(taxRegistrationNumber));
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
        });
        btnSelectTaxpayer.setBounds(147, 0, 139, 23);
        contentPane.add(btnSelectTaxpayer);
    }
}
