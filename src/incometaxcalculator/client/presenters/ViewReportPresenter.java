package incometaxcalculator.client.presenters;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.app.view_report.ViewReport;
import incometaxcalculator.boundaries.ViewReportBoundary;

public class ViewReportPresenter {
    public static double[] get_bar_chart_data(Taxpayer current_taxpayer) {
        ViewReportBoundary viewer = new ViewReport();
        return viewer.produce_report(current_taxpayer)[0];
    }

    public static double[] get_pie_chart_data(Taxpayer current_taxpayer) {
        ViewReportBoundary viewer = new ViewReport();
        return viewer.produce_report(current_taxpayer)[1];
    }
}
