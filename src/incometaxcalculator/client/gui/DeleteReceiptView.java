package incometaxcalculator.client.gui;

import java.io.IOException;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import incometaxcalculator.app.delete_receipt.DeleteReceipt;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.persistence.TaxpayerManager;

public class DeleteReceiptView {
    TaxpayerManager taxpayerManager;
    DefaultListModel<Integer> receiptsModel;

    public DeleteReceiptView(TaxpayerManager taxpayerManager, DefaultListModel<Integer> receiptsModel) {
        this.taxpayerManager = taxpayerManager;
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
                new DeleteReceipt(taxpayerManager).delete(receiptIDValue);
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
