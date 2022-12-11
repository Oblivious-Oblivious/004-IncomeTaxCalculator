package incometaxcalculator.client.gui.presenters;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.client.gui.views.ChartDisplayView;

public class ViewReportPresenter {
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
            current_taxpayer.getAmountOfReceiptKind(ReceiptKind.ENTERTAINMENT),
            current_taxpayer.getAmountOfReceiptKind(ReceiptKind.BASIC),
            current_taxpayer.getAmountOfReceiptKind(ReceiptKind.TRAVEL),
            current_taxpayer.getAmountOfReceiptKind(ReceiptKind.HEALTH),
            current_taxpayer.getAmountOfReceiptKind(ReceiptKind.OTHER)
        );
    }
}
