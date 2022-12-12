package incometaxcalculator.app.save_data;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class XMLLogWriter extends LogWriter {
    public XMLLogWriter(int taxRegistrationNumber) {
        this.taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);
    }

    @Override
    String get_type() {
        return "_LOG.xml";
    }

    String name() { return "<Name>" + this.taxpayer.fullname + "</Name>"; }
    String afm() { return "<AFM>" + this.taxpayer.taxRegistrationNumber + "</AFM>"; }
    String income() { return "<Income>" + this.taxpayer.income + "</Income>"; }
    String basicTax() { return "<BasicTax>" + this.taxpayer.getBasicTax() + "</BasicTax>"; }
    String taxIncrease() { return "<TaxIncrease>" + this.taxpayer.getVariationTaxOnReceipts() + "</TaxIncrease>"; }
    String taxDecrease() { return "<TaxDecrease>" + this.taxpayer.getVariationTaxOnReceipts() + "</TaxDecrease>"; }
    String totalTax() { return "<TotalTax>" + this.taxpayer.getTotalTax() + "</TotalTax>"; }
    String totalReceiptsGathered() { return "<TotalReceiptsGathered>" + this.taxpayer.totalReceiptsGathered + "</TotalReceiptsGathered>"; }
    String entertainment() { return "<Entertainment>" + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.ENTERTAINMENT) + "</Entertainment>"; }
    String basic() { return "<Basic>" + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.BASIC) + "</Basic>"; }
    String travel() { return "<Travel>" + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.TRAVEL) + "</Travel>"; }
    String health() { return "<Health>" + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.HEALTH) + "</Health>"; }
    String other() { return "<Other>" + this.taxpayer.getAmountOfReceiptKind(ReceiptKind.OTHER) + "</Other>"; }
}
