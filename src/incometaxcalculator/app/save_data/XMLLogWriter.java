package incometaxcalculator.app.save_data;

import incometaxcalculator.persistence.TaxpayerHashmap;

public class XMLLogWriter extends LogWriter {
    public XMLLogWriter(int taxRegistrationNumber) {
        this.taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);
    }

    @Override
    String get_type() {
        return "_LOG.xml";
    }

    @Override
    String[] get_label_format() {
        String tax_variation;
        if(this.taxpayer.getVariationTaxOnReceipts() > 0)
            tax_variation = "<TaxIncrease>" + variationTaxOnReceipts() + "</TaxIncrease>";
        else
            tax_variation = "<TaxDecrease>" + variationTaxOnReceipts() + "</TaxDecrease>";

        return new String[] {
            "<Name>" + name() + "</Name>",
            "<AFM>" + afm() + "</AFM>",
            "<Income>" + income() + "</Income>",
            "<BasicTax>" + basicTax() + "</BasicTax>",
            tax_variation,
            "<TotalTax>" + totalTax() + "</TotalTax>",
            "<Receipts>" + totalReceiptsGathered() + "</Receipts>",
            "<Entertainment>" + entertainment() + "</Entertainment>",
            "<Basic>" + basic() + "</Basic>",
            "<Travel>" + travel() + "</Travel>",
            "<Health>" + health() + "</Health>",
            "<Other>" + other() + "</Other>",
        };
    }
}
