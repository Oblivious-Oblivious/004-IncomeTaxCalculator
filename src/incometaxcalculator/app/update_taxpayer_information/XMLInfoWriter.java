package incometaxcalculator.app.update_taxpayer_information;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.persistence.TaxpayerManager;

// TODO Abstract commonalities into factory
public class XMLInfoWriter extends InfoWriter {
    private void generateTaxpayerReceipts(Taxpayer taxpayer, PrintWriter outputStream) {
        HashMap<Integer, Receipt> receiptsHashMap = taxpayer.receiptHashMap;
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            outputStream.println("<ReceiptID> " + getReceiptId(receipt) + " </ReceiptID>");
            outputStream.println("<Date> " + getReceiptIssueDate(receipt) + " </Date>");
            outputStream.println("<Kind> " + getReceiptKind(receipt) + " </Kind>");
            outputStream.println("<Amount> " + getReceiptAmount(receipt) + " </Amount>");
            outputStream.println("<Company> " + getCompanyName(receipt) + " </Company>");
            outputStream.println("<Country> " + getCompanyCountry(receipt) + " </Country>");
            outputStream.println("<City> " + getCompanyCity(receipt) + " </City>");
            outputStream.println("<Street> " + getCompanyStreet(receipt) + " </Street>");
            outputStream.println("<Number> " + getCompanyNumber(receipt) + " </Number>");
            outputStream.println();
        }
    }

    @Override
    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + "_INFO.xml"));
        Taxpayer taxpayer = TaxpayerManager.taxpayerHashMap.get(taxRegistrationNumber);

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
