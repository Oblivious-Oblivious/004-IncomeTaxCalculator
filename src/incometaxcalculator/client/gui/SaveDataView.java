package incometaxcalculator.client.gui;

import java.io.IOException;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.save_data.SaveData;
import incometaxcalculator.persistence.TaxpayerManager;

public class SaveDataView {
    TaxpayerManager taxpayerManager;
    int taxRegistrationNumber;

    public SaveDataView(TaxpayerManager taxpayerManager, int taxRegistrationNumber) {
        this.taxpayerManager = taxpayerManager;
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    public void export() {
        JPanel fileLoaderPanel = new JPanel(new BorderLayout());
        JPanel boxPanel = new JPanel(new BorderLayout());
        JPanel taxRegistrationNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel TRN = new JLabel("Choose file format.");
        // JTextField taxRegistrationNumberField = new JTextField(20);
        taxRegistrationNumberPanel.add(TRN);
        // taxRegistrationNumberPanel.add(taxRegistrationNumberField);
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

        int answer = JOptionPane.showConfirmDialog(null, fileLoaderPanel, "", JOptionPane.OK_CANCEL_OPTION);
        if(answer == 0) {
            try {
                try {
                    if(txtBox.isSelected()) {
                        new SaveData(taxpayerManager).export(taxRegistrationNumber, "txt");
                    }
                    else {
                        new SaveData(taxpayerManager).export(taxRegistrationNumber, "xml");
                    }
                }
                catch(IOException e1) {
                    JOptionPane.showMessageDialog(null, "Problem with opening file ." + taxRegistrationNumber + "_LOG.xml");
                }
                catch(WrongFileFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Wrong file format");
                }
            }
            catch(NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "The tax registration number must have only digits.");
            }
        }
    }
}
