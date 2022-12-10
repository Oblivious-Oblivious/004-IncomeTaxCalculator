package incometaxcalculator.client.gui;

import incometaxcalculator.app.taxpayers.Taxpayer;

// TODO Try to refactor out
import incometaxcalculator.persistence.TaxpayerManager;

public class ViewReportView {
    static final short ENTERTAINMENT = 0;
    static final short BASIC = 1;
    static final short TRAVEL = 2;
    static final short HEALTH = 3;
    static final short OTHER = 4;

    int taxRegistrationNumber;
    Taxpayer current_taxpayer;

    public ViewReportView(int taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
        this.current_taxpayer = TaxpayerManager.taxpayerHashMap.get(taxRegistrationNumber);
    }

    // TODO Get data from boundary
    public void produce_report() {
        ChartDisplay.createBarChart(
            current_taxpayer.getBasicTax(),
            current_taxpayer.getVariationTaxOnReceipts(),
            current_taxpayer.getTotalTax()
        );
        ChartDisplay.createPieChart(
            current_taxpayer.getAmountOfReceiptKind(ENTERTAINMENT),
            current_taxpayer.getAmountOfReceiptKind(BASIC),
            current_taxpayer.getAmountOfReceiptKind(TRAVEL),
            current_taxpayer.getAmountOfReceiptKind(HEALTH),
            current_taxpayer.getAmountOfReceiptKind(OTHER)
        );
    }
}
