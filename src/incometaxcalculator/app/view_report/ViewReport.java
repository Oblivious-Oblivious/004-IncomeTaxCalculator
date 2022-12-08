package incometaxcalculator.app.view_report;

import incometaxcalculator.boundaries.ViewReportBoundary;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.gui.ChartDisplay;

public class ViewReport implements ViewReportBoundary {
    static final short ENTERTAINMENT = 0;
    static final short BASIC = 1;
    static final short TRAVEL = 2;
    static final short HEALTH = 3;
    static final short OTHER = 4;

    TaxpayerManager taxpayerManager;
    int taxRegistrationNumber;

    public ViewReport(TaxpayerManager taxpayerManager, int taxRegistrationNumber) {
        this.taxpayerManager = taxpayerManager;
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    @Override
    public void produce_report() {
        ChartDisplay.createBarChart(
            taxpayerManager.getTaxpayerBasicTax(taxRegistrationNumber),
            taxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber),
            taxpayerManager.getTaxpayerTotalTax(taxRegistrationNumber)
        );
        ChartDisplay.createPieChart(
            taxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT),
            taxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC),
            taxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL),
            taxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH),
            taxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER)
        );
    }
}
