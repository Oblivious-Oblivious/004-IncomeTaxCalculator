package incometaxcalculator.client.gui.presenters;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.client.gui.views.ChartDisplayView;

public class ViewReportPresenter {
    static final short ENTERTAINMENT = 0;
    static final short BASIC = 1;
    static final short TRAVEL = 2;
    static final short HEALTH = 3;
    static final short OTHER = 4;

    Taxpayer current_taxpayer;

    public ViewReportPresenter(Taxpayer current_taxpayer) {
        this.current_taxpayer = current_taxpayer;
    }

    // TODO Get data from boundary
    public void produce_report() {
        ChartDisplayView.createBarChart(
            current_taxpayer.getBasicTax(),
            current_taxpayer.getVariationTaxOnReceipts(),
            current_taxpayer.getTotalTax()
        );
        ChartDisplayView.createPieChart(
            current_taxpayer.getAmountOfReceiptKind(ENTERTAINMENT),
            current_taxpayer.getAmountOfReceiptKind(BASIC),
            current_taxpayer.getAmountOfReceiptKind(TRAVEL),
            current_taxpayer.getAmountOfReceiptKind(HEALTH),
            current_taxpayer.getAmountOfReceiptKind(OTHER)
        );
    }
}
