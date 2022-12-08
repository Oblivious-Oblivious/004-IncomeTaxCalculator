package incometaxcalculator.delete_receipt;

import java.io.IOException;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import incometaxcalculator.boundaries.DeleteReceiptBoundary;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongReceiptKindException;

public class DeleteReceipt implements DeleteReceiptBoundary {
    TaxpayerManager taxpayerManager;
    DefaultListModel<Integer> receiptsModel;

    public DeleteReceipt(TaxpayerManager taxpayerManager, DefaultListModel<Integer> receiptsModel) {
        this.taxpayerManager = taxpayerManager;
        this.receiptsModel = receiptsModel;
    }

    @Override
    public void delete() {
        JPanel receiptRemoverPanel = new JPanel(new GridLayout(2, 2));
        JTextField receiptID = new JTextField(16);
        receiptRemoverPanel.add(new JLabel("Receipt ID:"));
        receiptRemoverPanel.add(receiptID);
        int op = JOptionPane.showConfirmDialog(null, receiptRemoverPanel, "", JOptionPane.OK_CANCEL_OPTION);
        
        if(op == 0) {
            int receiptIDValue = Integer.parseInt(receiptID.getText());
            try {
                this.taxpayerManager.removeReceipt(receiptIDValue);
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
