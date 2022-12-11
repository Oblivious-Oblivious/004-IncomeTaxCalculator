package incometaxcalculator.app.update_taxpayer_information;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerHashmap;

// TODO Abstract commonalities into factory
public class XMLInfoWriter extends InfoWriter {
    private void generateTaxpayerReceipts(Taxpayer taxpayer, PrintWriter outputStream) {
        HashMap<Integer, Receipt> receiptsHashMap = taxpayer.receiptHashMap;
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            outputStream.println("<ReceiptID> " + receipt.id + " </ReceiptID>");
            outputStream.println("<Date> " + receipt.issueDate + " </Date>");
            outputStream.println("<Kind> " + receipt.kind + " </Kind>");
            outputStream.println("<Amount> " + receipt.amount + " </Amount>");
            outputStream.println("<Company> " + receipt.company.name + " </Company>");
            outputStream.println("<Country> " + receipt.company.address.country + " </Country>");
            outputStream.println("<City> " + receipt.company.address.city + " </City>");
            outputStream.println("<Street> " + receipt.company.address.street + " </Street>");
            outputStream.println("<Number> " + receipt.company.address.number + " </Number>");
            outputStream.println();
        }
    }

    @Override
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_INFO.xml"));
        Taxpayer taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);

        outputStream.println("<Name> " + taxpayer.fullname + " </Name>");
        outputStream.println("<AFM> " + taxRegistrationNumber + " </AFM>");
        outputStream.println("<Status> " + taxpayer + " </Status>");
        outputStream.println("<Income> " + taxpayer.income + " </Income>");
        outputStream.println();
        outputStream.println("<Receipts>");
        outputStream.println();

        generateTaxpayerReceipts(taxpayer, outputStream);
        outputStream.close();
    }
}
