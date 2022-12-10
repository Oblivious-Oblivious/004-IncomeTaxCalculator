package incometaxcalculator.app.save_data;

import java.io.IOException;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerManager;

public abstract class LogWriter {
    public abstract void generateFile(int taxRegistrationNumber) throws IOException;

    public Taxpayer getTaxpayer(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayer(taxRegistrationNumber);
    }

    public String getTaxpayerName(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerName(taxRegistrationNumber);
    }

    public String getTaxpayerIncome(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerIncome(taxRegistrationNumber);
    }

    public String getTaxpayerStatus(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerStatus(taxRegistrationNumber);
    }

    public double getTaxpayerVariationTaxOnReceipts(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber);
    }

    public int getTaxpayerTotalReceiptsGathered(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerTotalReceiptsGathered(taxRegistrationNumber);
    }

    public float getTaxpayerAmountOfReceiptKind(int taxRegistrationNumber, short kind) {
        return new TaxpayerManager().getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, kind);
    }

    public double getTaxpayerTotalTax(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerTotalTax(taxRegistrationNumber);
    }

    public double getTaxpayerBasicTax(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerBasicTax(taxRegistrationNumber);
    }
}
