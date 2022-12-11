package incometaxcalculator.app.update_taxpayer_information;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerHashmap;

// TODO Abstract commonalities into factory
public class TXTInfoWriter extends InfoWriter {
    private void generateTaxpayerReceipts(Taxpayer taxpayer, PrintWriter outputStream) {
        HashMap<Integer, Receipt> receiptsHashMap = taxpayer.receiptHashMap;
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            outputStream.println("Receipt ID: " + receipt.id);
            outputStream.println("Date: " + receipt.issueDate);
            outputStream.println("Kind: " + receipt.kind);
            outputStream.println("Amount: " + receipt.amount);
            outputStream.println("Company: " + receipt.company.name);
            outputStream.println("Country: " + receipt.company.address.country);
            outputStream.println("City: " + receipt.company.address.city);
            outputStream.println("Street: " + receipt.company.address.street);
            outputStream.println("Number: " + receipt.company.address.number);
            outputStream.println();
        }
    }

    @Override
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_INFO.txt"));
        Taxpayer taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);

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
