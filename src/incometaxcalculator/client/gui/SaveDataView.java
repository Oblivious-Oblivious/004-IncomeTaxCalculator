package incometaxcalculator.client.gui;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.client.presenters.SaveDataPresenter;

public class SaveDataView {
    public static void export(JPanel contentPane, Taxpayer current_taxpayer) {
        JButton btnSaveData = new JButton("Save Data");
        btnSaveData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel fileLoaderPanel = new JPanel(new BorderLayout());
                JPanel taxRegistrationNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
                JPanel boxPanel = new JPanel(new BorderLayout());
                JPanel loadPanel = new JPanel(new GridLayout(1, 2));
                
                JLabel TRN = new JLabel("Choose file format.");
                taxRegistrationNumberPanel.add(TRN);
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
                    String error = SaveDataPresenter.save(txtBox.isSelected(), current_taxpayer.tax_registration_number);
                    if(error != "")
                        JOptionPane.showMessageDialog(null, error);
                }
            }
        });
        btnSaveData.setBounds(322, 0, 102, 23);
        contentPane.add(btnSaveData);
    }
}
