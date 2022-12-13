package incometaxcalculator.app.save_data;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class XMLLogWriter extends LogWriter {
    public XMLLogWriter(int tax_registration_number) {
        this.taxpayer = TaxpayerHashmap.get(tax_registration_number);
    }

    @Override
    String get_type() {
        return "_LOG.xml";
    }

    String name() { return "<Name>" + this.taxpayer.fullname + "</Name>"; }
    String afm() { return "<AFM>" + this.taxpayer.tax_registration_number + "</AFM>"; }
    String income() { return "<Income>" + this.taxpayer.income + "</Income>"; }
    String basic_tax() { return "<BasicTax>" + this.taxpayer.calculate_basic_tax() + "</BasicTax>"; }
    String tax_increase() { return "<TaxIncrease>" + this.taxpayer.get_variation_tax_on_receipts() + "</TaxIncrease>"; }
    String tax_decrease() { return "<TaxDecrease>" + this.taxpayer.get_variation_tax_on_receipts() + "</TaxDecrease>"; }
    String total_tax() { return "<TotalTax>" + this.taxpayer.calculate_total_tax() + "</TotalTax>"; }
    String total_receipts_gathered() { return "<TotalReceiptsGathered>" + this.taxpayer.total_receipts_gathered + "</TotalReceiptsGathered>"; }
    String entertainment() { return "<Entertainment>" + this.taxpayer.get_amount_of(ReceiptKind.ENTERTAINMENT) + "</Entertainment>"; }
    String basic() { return "<Basic>" + this.taxpayer.get_amount_of(ReceiptKind.BASIC) + "</Basic>"; }
    String travel() { return "<Travel>" + this.taxpayer.get_amount_of(ReceiptKind.TRAVEL) + "</Travel>"; }
    String health() { return "<Health>" + this.taxpayer.get_amount_of(ReceiptKind.HEALTH) + "</Health>"; }
    String other() { return "<Other>" + this.taxpayer.get_amount_of(ReceiptKind.OTHER) + "</Other>"; }
}
