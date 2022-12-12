package incometaxcalculator.boundaries;

import incometaxcalculator.app.taxpayers.Taxpayer;

public interface ViewReportBoundary {
    public double[][] produce_report(Taxpayer current_taxpayer);
}
