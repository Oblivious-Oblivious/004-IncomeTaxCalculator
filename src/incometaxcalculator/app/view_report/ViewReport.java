package incometaxcalculator.app.view_report;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.ViewReportBoundary;

public class ViewReport implements ViewReportBoundary {
    @Override
    public double[][] produce_report(Taxpayer current_taxpayer) {
        return new double[][] {
            new double[] {
                current_taxpayer.calculate_basic_tax(),
                current_taxpayer.get_variation_tax_on_receipts(),
                current_taxpayer.calculate_total_tax()
            },
            new double[] {
                current_taxpayer.get_amount_of(ReceiptKind.ENTERTAINMENT),
                current_taxpayer.get_amount_of(ReceiptKind.BASIC),
                current_taxpayer.get_amount_of(ReceiptKind.TRAVEL),
                current_taxpayer.get_amount_of(ReceiptKind.HEALTH),
                current_taxpayer.get_amount_of(ReceiptKind.OTHER)
            }
        };
    }
}
