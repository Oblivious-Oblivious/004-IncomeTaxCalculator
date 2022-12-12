package incometaxcalculator.app.save_data;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class TXTLogWriter extends LogWriter {
    public TXTLogWriter(int taxRegistrationNumber) {
        this.taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);
    }

    @Override
    String get_type() {
        return "_LOG.txt";
    }

    String name() { return "Name: " + this.taxpayer.fullname; }
    String afm() { return "AFM: " + this.taxpayer.taxRegistrationNumber; }
    String income() { return "Income: " + this.taxpayer.income; }
    String basicTax() { return "Basic Tax: " + this.taxpayer.getBasicTax(); }
    String taxIncrease() { return "Tax Increase: " + this.taxpayer.getVariationTaxOnReceipts(); }
    String taxDecrease() { return "Tax Decrease: " + this.taxpayer.getVariationTaxOnReceipts(); }
    String totalTax() { return "Total Tax: " + this.taxpayer.getTotalTax(); }
    String totalReceiptsGathered() { return "TotalReceiptsGathered: " + this.taxpayer.totalReceiptsGathered; }
    String entertainment() { return "Entertainment: " + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.ENTERTAINMENT); }
    String basic() { return "Basic: " + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.BASIC); }
    String travel() { return "Travel: " + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.TRAVEL); }
    String health() { return "Health: " + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.HEALTH); }
    String other() { return "Other: " + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.OTHER); }
}
