package incometaxcalculator.client.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import incometaxcalculator.client.presenters.SelectTaxpayerPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTaxpayerView {
    public static void select(JPanel contentPane) {
        JButton btnSelectTaxpayer = new JButton("Select Taxpayer");
        btnSelectTaxpayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectTaxpayerPresenter.select();
            }
        });
        btnSelectTaxpayer.setBounds(147, 0, 139, 23);
        contentPane.add(btnSelectTaxpayer);
    }
}
