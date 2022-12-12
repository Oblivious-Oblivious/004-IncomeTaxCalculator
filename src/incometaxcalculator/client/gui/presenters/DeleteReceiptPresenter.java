package incometaxcalculator.client.gui.presenters;

import java.io.IOException;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import incometaxcalculator.app.delete_receipt.DeleteReceipt;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class DeleteReceiptPresenter {
    public static void delete(JPanel contentPane, Taxpayer current_taxpayer, DefaultListModel<Integer> receiptsModel) {
        JButton btnDeleteReceipt = new JButton("Delete Receipt");
        btnDeleteReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel receiptRemoverPanel = new JPanel(new GridLayout(2, 2));
                JTextField receiptID = new JTextField(16);
                receiptRemoverPanel.add(new JLabel("Receipt ID:"));
                receiptRemoverPanel.add(receiptID);
                int op = JOptionPane.showConfirmDialog(null, receiptRemoverPanel, "", JOptionPane.OK_CANCEL_OPTION);

                if(op == 0) {
                    int receiptIDValue = Integer.parseInt(receiptID.getText());
                    try {
                        new DeleteReceipt().delete(current_taxpayer.taxRegistrationNumber, receiptIDValue);
                        receiptsModel.removeElement(receiptIDValue);
                    }
                    catch(IOException e1) {
                        JOptionPane.showMessageDialog(null, "Problem with opening file ." + receiptIDValue + "_INFO.txt");
                    }
                    catch(WrongReceiptKindException e1) {
                        JOptionPane.showMessageDialog(null, "Please check receipt's kind and try again.");
                    }
                }
            }
        });
        btnDeleteReceipt.setBounds(100, 0, 120, 23);
        contentPane.add(btnDeleteReceipt);
    }
}
