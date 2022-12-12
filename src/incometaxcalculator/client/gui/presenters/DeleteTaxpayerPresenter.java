package incometaxcalculator.client.gui.presenters;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import incometaxcalculator.app.delete_taxpayer.DeleteTaxpayer;

public class DeleteTaxpayerPresenter {
    public static void delete(JPanel contentPane, DefaultListModel<String> taxRegisterNumberModel) {
        JButton btnDeleteTaxpayer = new JButton("Delete Taxpayer");
        btnDeleteTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
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
        });
        btnDeleteTaxpayer.setBounds(287, 0, 146, 23);
        contentPane.add(btnDeleteTaxpayer);
    }
}
