package incometaxcalculator.app.save_data;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class XMLLogWriter extends LogWriter {
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_LOG.xml"));
        Taxpayer taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);

        outputStream.println("<Name> " + taxpayer.fullname + " </Name>");
        outputStream.println("<AFM> " + taxRegistrationNumber + " </AFM>");
        outputStream.println("<Income> " + taxpayer.income + " </Income>");
        outputStream.println("<BasicTax> " + taxpayer.getBasicTax() + " </BasicTax>");

        if(taxpayer.getVariationTaxOnReceipts() > 0)
            outputStream.println("<TaxIncrease> " + taxpayer.getVariationTaxOnReceipts() + " </TaxIncrease>");
        else
            outputStream.println("<TaxDecrease> " + taxpayer.getVariationTaxOnReceipts() + " </TaxDecrease>");

        outputStream.println("<TotalTax> " + taxpayer.getTotalTax() + " </TotalTax>");
        outputStream.println("<Receipts> " + taxpayer.totalReceiptsGathered + " </Receipts>");
        outputStream.println("<Entertainment> " + taxpayer.getAmountOfReceiptKind(ENTERTAINMENT) + " </Entertainment>");
        outputStream.println("<Basic> " + taxpayer.getAmountOfReceiptKind(BASIC) + " </Basic>");
        outputStream.println("<Travel> " + taxpayer.getAmountOfReceiptKind(TRAVEL) + " </Travel>");
        outputStream.println("<Health> " + taxpayer.getAmountOfReceiptKind(HEALTH) + " </Health>");
        outputStream.println("<Other> " + taxpayer.getAmountOfReceiptKind(OTHER) + " </Other>");
        outputStream.close();
    }
}
