package incometaxcalculator.client.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.client.gui.helpers.Pair;
import incometaxcalculator.client.presenters.AddReceiptPresenter;

public class AddReceiptView {
    public static void submit(JPanel contentPane, Taxpayer current_taxpayer, DefaultListModel<Integer> receiptsModel) {
        JButton btnAddReceipt = new JButton("Add Receipt");
        btnAddReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel receiptImporterPanel = new JPanel(new GridLayout(9, 2));
                JTextField receipt_id_field = new JTextField(16);
                JTextField date_field = new JTextField(16);
                JTextField kind_field = new JTextField(16);
                JTextField amount_field = new JTextField(16);
                JTextField company_field = new JTextField(16);
                JTextField country_field = new JTextField(16);
                JTextField city_field = new JTextField(16);
                JTextField street_field = new JTextField(16);
                JTextField number_field = new JTextField(16);

                String receipt_id_value, date_value, amount_value, kind_value, company_value, country_value, city_value, street_value, number_value;
                receiptImporterPanel.add(new JLabel("Receipt ID:"));
                receiptImporterPanel.add(receipt_id_field);
                receiptImporterPanel.add(new JLabel("Date:"));
                receiptImporterPanel.add(date_field);
                receiptImporterPanel.add(new JLabel("Kind:"));
                receiptImporterPanel.add(kind_field);
                receiptImporterPanel.add(new JLabel("Amount:"));
                receiptImporterPanel.add(amount_field);
                receiptImporterPanel.add(new JLabel("Company:"));
                receiptImporterPanel.add(company_field);
                receiptImporterPanel.add(new JLabel("Country:"));
                receiptImporterPanel.add(country_field);
                receiptImporterPanel.add(new JLabel("City:"));
                receiptImporterPanel.add(city_field);
                receiptImporterPanel.add(new JLabel("Street:"));
                receiptImporterPanel.add(street_field);
                receiptImporterPanel.add(new JLabel("Number:"));
                receiptImporterPanel.add(number_field);
                
                int op = JOptionPane.showConfirmDialog(null, receiptImporterPanel, "", JOptionPane.OK_CANCEL_OPTION);
                if(op == 0) {
                    receipt_id_value = receipt_id_field.getText();
                    date_value = date_field.getText();
                    kind_value = kind_field.getText();
                    amount_value = amount_field.getText();
                    company_value = company_field.getText();
                    country_value = country_field.getText();
                    city_value = city_field.getText();
                    street_value = street_field.getText();
                    number_value = number_field.getText();

                    Pair<Integer, String> add_result = AddReceiptPresenter.add(receipt_id_value, date_value, amount_value, kind_value, company_value, country_value, city_value, street_value, number_value, current_taxpayer.tax_registration_number);
                    if(add_result.first == -1)
                        JOptionPane.showMessageDialog(null, add_result.second);
                    else
                        receiptsModel.addElement(add_result.first);
                }
            }
        });
        btnAddReceipt.setBounds(0, 0, 102, 23);
        contentPane.add(btnAddReceipt);
    }
}
