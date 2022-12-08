package incometaxcalculator.app.load_taxpayer;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileEndingException;
import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;
import incometaxcalculator.boundaries.LoadTaxpayerBoundary;
import incometaxcalculator.data.management.TaxpayerManager;

public class LoadTaxpayer implements LoadTaxpayerBoundary {
    TaxpayerManager taxpayerManager;
    DefaultListModel<String> taxRegisterNumberModel;
    JPanel fileLoaderPanel;
    JTextField taxRegistrationNumberField;
    JCheckBox txtBox;

    public LoadTaxpayer(
        TaxpayerManager taxpayerManager,
        DefaultListModel<String> taxRegisterNumberModel,
        JPanel fileLoaderPanel,
        JTextField taxRegistrationNumberField,
        JCheckBox txtBox
    ) {
        this.taxpayerManager = taxpayerManager;
        this.taxRegisterNumberModel = taxRegisterNumberModel;
        this.fileLoaderPanel = fileLoaderPanel;
        this.taxRegistrationNumberField = taxRegistrationNumberField;
        this.txtBox = txtBox;
    }

    @Override
    public void load() {
        int answer = JOptionPane.showConfirmDialog(null, fileLoaderPanel, "", JOptionPane.OK_CANCEL_OPTION);
        if(answer == 0) {
            String taxRegistrationNumber = taxRegistrationNumberField.getText();
            while(taxRegistrationNumber.length() != 9 && answer == 0) {
                JOptionPane.showMessageDialog(null, "The tax  registration number must have 9 digit.\n" + " Try again.");
                answer = JOptionPane.showConfirmDialog(null, fileLoaderPanel, "", JOptionPane.OK_CANCEL_OPTION);
                taxRegistrationNumber = taxRegistrationNumberField.getText();
            }
            
            if(answer == 0) {
                String type;
                if(txtBox.isSelected()) {
                    type = "_INFO.txt";
                }
                else {
                    type = "_INFO.xml";
                }

                try {
                    int trn = Integer.parseInt(taxRegistrationNumber);
                    String taxRegistrationNumberFile = taxRegistrationNumber + type;
                    if(this.taxpayerManager.containsTaxpayer(trn)) {
                        JOptionPane.showMessageDialog(null, "This taxpayer is already loaded.");
                    }
                    else {
                        this.taxpayerManager.loadTaxpayer(taxRegistrationNumberFile);
                        this.taxRegisterNumberModel.addElement(taxRegistrationNumber);
                    }
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "The tax registration number must have only digits.");
                }
                catch(IOException e1) {
                    JOptionPane.showMessageDialog(null, "The file doesn't exists.");
                }
                catch(WrongFileFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please check your file format and try again.");
                }
                catch(WrongFileEndingException e1) {
                    JOptionPane.showMessageDialog(null, "Please check your file ending and try again.");
                }
                catch(WrongTaxpayerStatusException e1) {
                    JOptionPane.showMessageDialog(null, "Please check taxpayer's status and try again.");
                }
                catch(WrongReceiptKindException e1) {
                    JOptionPane.showMessageDialog(null, "Please check receipts kind and try again.");
                }
                catch(WrongReceiptDateException e1) {
                    JOptionPane.showMessageDialog(null, "Please make sure your date is " + "DD/MM/YYYY and try again.");
                }
            }
        }
    }
}
