package incometaxcalculator.app.save_data;

import incometaxcalculator.persistence.TaxpayerHashmap;

public class TXTLogWriter extends LogWriter {
    public TXTLogWriter(int taxRegistrationNumber) {
        this.taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);
    }

    @Override
    String get_type() {
        return "_LOG.txt";
    }

    @Override
    String[] get_label_format() {
        String tax_variation;
        if(this.taxpayer.getVariationTaxOnReceipts() > 0)
            tax_variation = "Tax Increase: " + variationTaxOnReceipts();
        else
            tax_variation = "Tax Decrease: " + variationTaxOnReceipts();

        return new String[] {
            "Name: " + name(),
            "AFM: " + afm(),
            "Income: " + income(),
            "Basic Tax: " + basicTax(),
            tax_variation,
            "Total Tax: " + totalTax(),
            "TotalReceiptsGathered: " + totalReceiptsGathered(),
            "Entertainment: " + entertainment(),
            "Basic: " + basic(),
            "Travel: " + travel(),
            "Health: " + health(),
            "Other: " + other(),
        };
    }
}
