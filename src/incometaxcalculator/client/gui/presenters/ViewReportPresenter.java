package incometaxcalculator.client.gui.presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.client.gui.views.ChartDisplayView;

public class ViewReportPresenter {
    public static void produce_report(JPanel contentPane, Taxpayer current_taxpayer) {
        JButton btnViewReport = new JButton("View Report");
        btnViewReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Get data from boundary
                ChartDisplayView.createBarChart(
                    current_taxpayer.getBasicTax(),
                    current_taxpayer.getVariationTaxOnReceipts(),
                    current_taxpayer.getTotalTax()
                );
                ChartDisplayView.createPieChart(
                    current_taxpayer.getAmountOfReceiptKind(ReceiptKind.ENTERTAINMENT),
                    current_taxpayer.getAmountOfReceiptKind(ReceiptKind.BASIC),
                    current_taxpayer.getAmountOfReceiptKind(ReceiptKind.TRAVEL),
                    current_taxpayer.getAmountOfReceiptKind(ReceiptKind.HEALTH),
                    current_taxpayer.getAmountOfReceiptKind(ReceiptKind.OTHER)
                );
            }
        });
        btnViewReport.setBounds(214, 0, 109, 23);
        contentPane.add(btnViewReport);
    }
}
