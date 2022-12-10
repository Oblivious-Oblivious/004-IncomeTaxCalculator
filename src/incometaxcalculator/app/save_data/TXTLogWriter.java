package incometaxcalculator.app.save_data;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerManager;

public class TXTLogWriter extends LogWriter {
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_LOG.txt"));
        Taxpayer taxpayer = TaxpayerManager.taxpayerHashMap.get(taxRegistrationNumber);
        
        outputStream.println("Name: " + taxpayer.fullname);
        outputStream.println("AFM: " + taxRegistrationNumber);
        outputStream.println("Income: " + taxpayer.income);
        outputStream.println("Basic Tax: " + taxpayer.getBasicTax());

        if(taxpayer.getVariationTaxOnReceipts() > 0)
            outputStream.println("Tax Increase: " + taxpayer.getVariationTaxOnReceipts());
        else
            outputStream.println("Tax Decrease: " + taxpayer.getVariationTaxOnReceipts());

        outputStream.println("Total Tax: " + taxpayer.getTotalTax());
        outputStream.println("TotalReceiptsGathered: " + taxpayer.totalReceiptsGathered);
        outputStream.println("Entertainment: " + taxpayer.getAmountOfReceiptKind(ENTERTAINMENT));
        outputStream.println("Basic: " + taxpayer.getAmountOfReceiptKind(BASIC));
        outputStream.println("Travel: " + taxpayer.getAmountOfReceiptKind(TRAVEL));
        outputStream.println("Health: " + taxpayer.getAmountOfReceiptKind(HEALTH));
        outputStream.println("Other: " + taxpayer.getAmountOfReceiptKind(OTHER));
        outputStream.close();
    }
}
