package incometaxcalculator.app.save_data;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.persistence.TaxpayerManager;

public class TXTLogWriter extends LogWriter {
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_LOG.txt"));
        outputStream.println("Name: " + TaxpayerManager.getTaxpayerName(taxRegistrationNumber));
        outputStream.println("AFM: " + taxRegistrationNumber);
        outputStream.println("Income: " + TaxpayerManager.getTaxpayerIncome(taxRegistrationNumber));
        outputStream.println("Basic Tax: " + TaxpayerManager.getTaxpayerBasicTax(taxRegistrationNumber));

        if(TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0)
            outputStream.println("Tax Increase: " + TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber));
        else
            outputStream.println("Tax Decrease: " + TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber));

        outputStream.println("Total Tax: " + TaxpayerManager.getTaxpayerTotalTax(taxRegistrationNumber));
        outputStream.println("TotalReceiptsGathered: " + TaxpayerManager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber));
        outputStream.println("Entertainment: " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT));
        outputStream.println("Basic: " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC));
        outputStream.println("Travel: " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL));
        outputStream.println("Health: " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH));
        outputStream.println("Other: " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER));
        outputStream.close();
    }
}
