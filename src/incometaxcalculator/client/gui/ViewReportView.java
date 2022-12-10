package incometaxcalculator.client.gui;

import incometaxcalculator.persistence.TaxpayerManager;

public class ViewReportView {
    static final short ENTERTAINMENT = 0;
    static final short BASIC = 1;
    static final short TRAVEL = 2;
    static final short HEALTH = 3;
    static final short OTHER = 4;

    int taxRegistrationNumber;

    public ViewReportView(int taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    public void produce_report() {
        ChartDisplay.createBarChart(
            TaxpayerManager.getTaxpayerBasicTax(taxRegistrationNumber),
            TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber),
            TaxpayerManager.getTaxpayerTotalTax(taxRegistrationNumber)
        );
        ChartDisplay.createPieChart(
            TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT),
            TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC),
            TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL),
            TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH),
            TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER)
        );
    }
}
