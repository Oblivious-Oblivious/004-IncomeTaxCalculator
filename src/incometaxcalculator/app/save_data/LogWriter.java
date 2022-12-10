package incometaxcalculator.app.save_data;

import java.io.IOException;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerManager;

public abstract class LogWriter {
    public abstract void generateFile(int taxRegistrationNumber) throws IOException;

    public Taxpayer getTaxpayer(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayer(taxRegistrationNumber);
    }

    public String getTaxpayerName(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayerName(taxRegistrationNumber);
    }

    public String getTaxpayerIncome(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayerIncome(taxRegistrationNumber);
    }

    public String getTaxpayerStatus(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayerStatus(taxRegistrationNumber);
    }

    public double getTaxpayerVariationTaxOnReceipts(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber);
    }

    public int getTaxpayerTotalReceiptsGathered(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber);
    }

    public float getTaxpayerAmountOfReceiptKind(int taxRegistrationNumber, short kind) {
        return TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, kind);
    }

    public double getTaxpayerTotalTax(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayerTotalTax(taxRegistrationNumber);
    }

    public double getTaxpayerBasicTax(int taxRegistrationNumber) {
        return TaxpayerManager.getTaxpayerBasicTax(taxRegistrationNumber);
    }
}
