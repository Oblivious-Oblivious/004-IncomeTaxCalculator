package incometaxcalculator.app.save_data;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.persistence.TaxpayerManager;

public class XMLLogWriter extends LogWriter {
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_LOG.xml"));
        outputStream.println("<Name> " + TaxpayerManager.getTaxpayerName(taxRegistrationNumber) + " </Name>");
        outputStream.println("<AFM> " + taxRegistrationNumber + " </AFM>");
        outputStream.println("<Income> " + TaxpayerManager.getTaxpayerIncome(taxRegistrationNumber) + " </Income>");
        outputStream.println("<BasicTax> " + TaxpayerManager.getTaxpayerBasicTax(taxRegistrationNumber) + " </BasicTax>");

        if (TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0)
            outputStream.println("<TaxIncrease> " + TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + " </TaxIncrease>");
        else
            outputStream.println("<TaxDecrease> " + TaxpayerManager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + " </TaxDecrease>");

        outputStream.println("<TotalTax> " + TaxpayerManager.getTaxpayerTotalTax(taxRegistrationNumber) + " </TotalTax>");
        outputStream.println("<Receipts> " + TaxpayerManager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber) + " </Receipts>");
        outputStream.println("<Entertainment> " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT) + " </Entertainment>");
        outputStream.println("<Basic> " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC) + " </Basic>");
        outputStream.println("<Travel> " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL) + " </Travel>");
        outputStream.println("<Health> " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH) + " </Health>");
        outputStream.println("<Other> " + TaxpayerManager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER) + " </Other>");
        outputStream.close();
    }
}
