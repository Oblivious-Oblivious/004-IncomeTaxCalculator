package incometaxcalculator.app.update_taxpayer_information;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerManager;

// TODO Abstract commonalities into factory
public class TXTInfoWriter extends InfoWriter {
    private void generateTaxpayerReceipts(Taxpayer taxpayer, PrintWriter outputStream) {
        HashMap<Integer, Receipt> receiptsHashMap = taxpayer.receiptHashMap;
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            outputStream.println("Receipt ID: " + getReceiptId(receipt));
            outputStream.println("Date: " + getReceiptIssueDate(receipt));
            outputStream.println("Kind: " + getReceiptKind(receipt));
            outputStream.println("Amount: " + getReceiptAmount(receipt));
            outputStream.println("Company: " + getCompanyName(receipt));
            outputStream.println("Country: " + getCompanyCountry(receipt));
            outputStream.println("City: " + getCompanyCity(receipt));
            outputStream.println("Street: " + getCompanyStreet(receipt));
            outputStream.println("Number: " + getCompanyNumber(receipt));
            outputStream.println();
        }
    }

    @Override
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_INFO.txt"));
        Taxpayer taxpayer = TaxpayerManager.taxpayerHashMap.get(taxRegistrationNumber);

        outputStream.println("Name: " + taxpayer.fullname);
        outputStream.println("AFM: " + taxRegistrationNumber);
        outputStream.println("Status: " + taxpayer);
        outputStream.println("Income: " + taxpayer.income);
        outputStream.println();
        outputStream.println("Receipts:");
        outputStream.println();

        generateTaxpayerReceipts(taxpayer, outputStream);
        outputStream.close();
    }
}
