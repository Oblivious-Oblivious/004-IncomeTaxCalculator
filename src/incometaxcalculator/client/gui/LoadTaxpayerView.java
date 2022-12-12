package incometaxcalculator.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import incometaxcalculator.client.presenters.LoadTaxpayerPresenter;

public class LoadTaxpayerView {
    public static void load(JPanel contentPane, DefaultListModel<String> taxRegisterNumberModel) {
        JList<String> taxRegisterNumberList = new JList<String>(taxRegisterNumberModel);
        taxRegisterNumberList.setBackground(new Color(153, 204, 204));
        taxRegisterNumberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taxRegisterNumberList.setSelectedIndex(0);
        taxRegisterNumberList.setVisibleRowCount(3);

        JScrollPane taxRegisterNumberListScrollPane = new JScrollPane(taxRegisterNumberList);
        taxRegisterNumberListScrollPane.setSize(300, 300);
        taxRegisterNumberListScrollPane.setLocation(70, 100);
        contentPane.add(taxRegisterNumberListScrollPane);

        JPanel fileLoaderPanel = new JPanel(new BorderLayout());
        JPanel boxPanel = new JPanel(new BorderLayout());
        JPanel taxRegistrationNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel TRN = new JLabel("Give the tax registration number:");
        JTextField taxRegistrationNumberField = new JTextField(20);
        taxRegistrationNumberPanel.add(TRN);
        taxRegistrationNumberPanel.add(taxRegistrationNumberField);
        JPanel loadPanel = new JPanel(new GridLayout(1, 2));
        loadPanel.add(taxRegistrationNumberPanel);
        fileLoaderPanel.add(boxPanel, BorderLayout.NORTH);
        fileLoaderPanel.add(loadPanel, BorderLayout.CENTER);
        JCheckBox txtBox = new JCheckBox("Txt file");
        JCheckBox xmlBox = new JCheckBox("Xml file");

        txtBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xmlBox.setSelected(false);
            }
        });

        xmlBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtBox.setSelected(false);
            }
        });
        txtBox.doClick();
        boxPanel.add(txtBox, BorderLayout.WEST);
        boxPanel.add(xmlBox, BorderLayout.EAST);

        JButton btnLoadTaxpayer = new JButton("Load Taxpayer");
        btnLoadTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(null, fileLoaderPanel, "", JOptionPane.OK_CANCEL_OPTION);
                if(answer == 0) {
                    String taxRegistrationNumber = taxRegistrationNumberField.getText();
                    while(taxRegistrationNumber.length() != 9 && answer == 0) {
                        JOptionPane.showMessageDialog(null, "The tax  registration number must have 9 digit.\n" + " Try again.");
                        answer = JOptionPane.showConfirmDialog(null, fileLoaderPanel, "", JOptionPane.OK_CANCEL_OPTION);
                        taxRegistrationNumber = taxRegistrationNumberField.getText();
                    }

                    if(answer == 0) {
                        String error = LoadTaxpayerPresenter.load(txtBox.isSelected(), taxRegistrationNumber);
                        if(error != "")
                            JOptionPane.showMessageDialog(null, error);
                        else
                            taxRegisterNumberModel.addElement(taxRegistrationNumber);
                    }
                }
            }
        });
        btnLoadTaxpayer.setBounds(0, 0, 146, 23);
        contentPane.add(btnLoadTaxpayer);
    }
}
