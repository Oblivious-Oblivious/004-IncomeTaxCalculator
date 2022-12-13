package incometaxcalculator.client.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.client.gui.helpers.Pair;
import incometaxcalculator.client.presenters.DeleteReceiptPresenter;

public class DeleteReceiptView {
    public static void delete(JPanel contentPane, Taxpayer current_taxpayer, DefaultListModel<Integer> receiptsModel) {
        JButton btnDeleteReceipt = new JButton("Delete Receipt");
        btnDeleteReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel receiptRemoverPanel = new JPanel(new GridLayout(2, 2));
                JTextField receipt_id_field = new JTextField(16);
                receiptRemoverPanel.add(new JLabel("Receipt ID:"));
                receiptRemoverPanel.add(receipt_id_field);

                int op = JOptionPane.showConfirmDialog(null, receiptRemoverPanel, "", JOptionPane.OK_CANCEL_OPTION);
                if(op == 0) {
                    String receipt_id_value = receipt_id_field.getText();

                    Pair<Integer, String> delete_result = DeleteReceiptPresenter.delete(receipt_id_value, current_taxpayer.tax_registration_number);
                    if(delete_result.first == -1)
                        JOptionPane.showMessageDialog(null, delete_result.second);
                    else
                        receiptsModel.removeElement(delete_result.first);
                }
            }
        });
        btnDeleteReceipt.setBounds(100, 0, 120, 23);
        contentPane.add(btnDeleteReceipt);
    }
}
