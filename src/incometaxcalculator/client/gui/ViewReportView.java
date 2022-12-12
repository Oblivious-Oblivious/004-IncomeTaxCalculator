package incometaxcalculator.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.client.gui.helpers.ChartDisplayView;
import incometaxcalculator.client.presenters.ViewReportPresenter;

public class ViewReportView {
    public static void produce_report(JPanel contentPane, Taxpayer current_taxpayer) {
        JButton btnViewReport = new JButton("View Report");
        btnViewReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double[] bar_chart_data = ViewReportPresenter.get_bar_chart_data(current_taxpayer);
                ChartDisplayView.createBarChart(
                    bar_chart_data[0],
                    bar_chart_data[1],
                    bar_chart_data[2]
                );

                double[] pie_chart_data = ViewReportPresenter.get_pie_chart_data(current_taxpayer);
                ChartDisplayView.createPieChart(
                    pie_chart_data[0],
                    pie_chart_data[1],
                    pie_chart_data[2],
                    pie_chart_data[3],
                    pie_chart_data[4]
                );
            }
        });
        btnViewReport.setBounds(214, 0, 109, 23);
        contentPane.add(btnViewReport);
    }
}
