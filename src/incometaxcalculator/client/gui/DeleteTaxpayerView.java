package incometaxcalculator.client.gui;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import incometaxcalculator.client.presenters.DeleteTaxpayerPresenter;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTaxpayerView {
    public static void delete(JPanel contentPane, DefaultListModel<String> taxRegisterNumberModel) {
        JButton btnDeleteTaxpayer = new JButton("Delete Taxpayer");
        btnDeleteTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String trn = JOptionPane.showInputDialog(null, "Give the tax registration number that you want to delete: ");

                String error = DeleteTaxpayerPresenter.delete(trn);
                if(error != "")
                    JOptionPane.showMessageDialog(null, error);
                else
                    taxRegisterNumberModel.removeElement(trn);
            }
        });
        btnDeleteTaxpayer.setBounds(287, 0, 146, 23);
        contentPane.add(btnDeleteTaxpayer);
    }
}
