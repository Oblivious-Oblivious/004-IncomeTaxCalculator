package incometaxcalculator.app.view_report;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.ViewReportBoundary;

public class ViewReport implements ViewReportBoundary {
    @Override
    public double[][] produce_report(Taxpayer current_taxpayer) {
        return new double[][] {
            new double[] {
                current_taxpayer.getBasicTax(),
                current_taxpayer.getVariationTaxOnReceipts(),
                current_taxpayer.getTotalTax()
            },
            new double[] {
                current_taxpayer.getAmountOfReceiptKind(ReceiptKind.ENTERTAINMENT),
                current_taxpayer.getAmountOfReceiptKind(ReceiptKind.BASIC),
                current_taxpayer.getAmountOfReceiptKind(ReceiptKind.TRAVEL),
                current_taxpayer.getAmountOfReceiptKind(ReceiptKind.HEALTH),
                current_taxpayer.getAmountOfReceiptKind(ReceiptKind.OTHER)
            }
        };
    }
}
