package incometaxcalculator.client.gui.presenters;

import java.io.IOException;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import incometaxcalculator.app.add_receipt.AddReceipt;
import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class AddReceiptPresenter {
    Taxpayer current_taxpayer;
    DefaultListModel<Integer> receiptsModel;

    public AddReceiptPresenter(Taxpayer current_taxpayer, DefaultListModel<Integer> receiptsModel) {
        this.current_taxpayer = current_taxpayer;
        this.receiptsModel = receiptsModel;
    }

    public void submit() {
        JPanel receiptImporterPanel = new JPanel(new GridLayout(9, 2));
        JTextField receiptID = new JTextField(16);
        JTextField date = new JTextField(16);
        JTextField kind = new JTextField(16);
        JTextField amount = new JTextField(16);
        JTextField company = new JTextField(16);
        JTextField country = new JTextField(16);
        JTextField city = new JTextField(16);
        JTextField street = new JTextField(16);
        JTextField number = new JTextField(16);
        int receiptIDValue, numberValue;
        float amountValue;
        String dateValue, companyValue, countryValue;
        ReceiptKind kindValue;
        String cityValue, streetValue;
        receiptImporterPanel.add(new JLabel("Receipt ID:"));
        receiptImporterPanel.add(receiptID);
        receiptImporterPanel.add(new JLabel("Date:"));
        receiptImporterPanel.add(date);
        receiptImporterPanel.add(new JLabel("Kind:"));
        receiptImporterPanel.add(kind);
        receiptImporterPanel.add(new JLabel("Amount:"));
        receiptImporterPanel.add(amount);
        receiptImporterPanel.add(new JLabel("Company:"));
        receiptImporterPanel.add(company);
        receiptImporterPanel.add(new JLabel("Country:"));
        receiptImporterPanel.add(country);
        receiptImporterPanel.add(new JLabel("City:"));
        receiptImporterPanel.add(city);
        receiptImporterPanel.add(new JLabel("Street:"));
        receiptImporterPanel.add(street);
        receiptImporterPanel.add(new JLabel("Number:"));
        receiptImporterPanel.add(number);
        int op = JOptionPane.showConfirmDialog(null, receiptImporterPanel, "", JOptionPane.OK_CANCEL_OPTION);
        if(op == 0) {
            receiptIDValue = Integer.parseInt(receiptID.getText());
            dateValue = date.getText();
            kindValue = ReceiptKind.from_string(kind.getText());
            amountValue = Float.parseFloat(amount.getText());
            companyValue = company.getText();
            countryValue = country.getText();
            cityValue = city.getText();
            streetValue = street.getText();
            numberValue = Integer.parseInt(number.getText());

            try {
                new AddReceipt().add(receiptIDValue, dateValue, amountValue, kindValue, companyValue, countryValue, cityValue, streetValue, numberValue, this.current_taxpayer.taxRegistrationNumber);
                receiptsModel.addElement(receiptIDValue);
            }
            catch(IOException e1) {
                JOptionPane.showMessageDialog(null, "Problem with opening file ." + receiptIDValue + "_INFO.txt");
            }
            catch(WrongReceiptKindException e1) {
                JOptionPane.showMessageDialog(null, "Please check receipts kind and try again.");
            }
            catch(WrongReceiptDateException e1) {
                JOptionPane.showMessageDialog(null, "Please make sure your date " + "is DD/MM/YYYY and try again.");
            }
            catch(ReceiptAlreadyExistsException e1) {
                JOptionPane.showMessageDialog(null, "Receipt ID already exists.");
            }
        }
    }
}
