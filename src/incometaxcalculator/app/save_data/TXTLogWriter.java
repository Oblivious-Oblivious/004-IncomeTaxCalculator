package incometaxcalculator.app.save_data;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class TXTLogWriter extends LogWriter {
    public TXTLogWriter(int tax_registration_number) {
        this.taxpayer = TaxpayerHashmap.get(tax_registration_number);
    }

    @Override
    String get_type() {
        return "_LOG.txt";
    }

    String name() { return "Name: " + this.taxpayer.fullname; }
    String afm() { return "AFM: " + this.taxpayer.tax_registration_number; }
    String income() { return "Income: " + this.taxpayer.income; }
    String basic_tax() { return "Basic Tax: " + this.taxpayer.calculate_basic_tax(); }
    String tax_increase() { return "Tax Increase: " + this.taxpayer.get_variation_tax_on_receipts(); }
    String tax_decrease() { return "Tax Decrease: " + this.taxpayer.get_variation_tax_on_receipts(); }
    String total_tax() { return "Total Tax: " + this.taxpayer.calculate_total_tax(); }
    String total_receipts_gathered() { return "TotalReceiptsGathered: " + this.taxpayer.total_receipts_gathered; }
    String entertainment() { return "Entertainment: " + this.taxpayer.get_amount_of(ReceiptKind.ENTERTAINMENT); }
    String basic() { return "Basic: " + this.taxpayer.get_amount_of(ReceiptKind.BASIC); }
    String travel() { return "Travel: " + this.taxpayer.get_amount_of(ReceiptKind.TRAVEL); }
    String health() { return "Health: " + this.taxpayer.get_amount_of(ReceiptKind.HEALTH); }
    String other() { return "Other: " + this.taxpayer.get_amount_of(ReceiptKind.OTHER); }
}
