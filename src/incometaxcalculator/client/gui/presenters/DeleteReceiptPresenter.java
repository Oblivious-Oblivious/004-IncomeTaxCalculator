package incometaxcalculator.client.gui.presenters;

import java.io.IOException;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import incometaxcalculator.app.delete_receipt.DeleteReceipt;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class DeleteReceiptPresenter {
    Taxpayer current_taxpayer;
    DefaultListModel<Integer> receiptsModel;

    public DeleteReceiptPresenter(Taxpayer current_taxpayer, DefaultListModel<Integer> receiptsModel) {
        this.current_taxpayer = current_taxpayer;
        this.receiptsModel = receiptsModel;
    }

    public void delete() {
        JPanel receiptRemoverPanel = new JPanel(new GridLayout(2, 2));
        JTextField receiptID = new JTextField(16);
        receiptRemoverPanel.add(new JLabel("Receipt ID:"));
        receiptRemoverPanel.add(receiptID);
        int op = JOptionPane.showConfirmDialog(null, receiptRemoverPanel, "", JOptionPane.OK_CANCEL_OPTION);

        if(op == 0) {
            int receiptIDValue = Integer.parseInt(receiptID.getText());
            try {
                new DeleteReceipt().delete(this.current_taxpayer.taxRegistrationNumber, receiptIDValue);
                this.receiptsModel.removeElement(receiptIDValue);
            }
            catch(IOException e1) {
                JOptionPane.showMessageDialog(null, "Problem with opening file ." + receiptIDValue + "_INFO.txt");
            }
            catch(WrongReceiptKindException e1) {
                JOptionPane.showMessageDialog(null, "Please check receipt's kind and try again.");
            }
        }
    }
}
