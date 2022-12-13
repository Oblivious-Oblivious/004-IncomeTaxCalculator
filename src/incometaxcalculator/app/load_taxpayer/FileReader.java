package incometaxcalculator.app.load_taxpayer;

import java.io.BufferedReader;
import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongFileFormatException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;
import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.app.taxpayers.TaxpayerFactory;
import incometaxcalculator.app.taxpayers.TaxpayerType;
import incometaxcalculator.persistence.TaxpayerHashmap;

public abstract class FileReader {
    abstract boolean receipt_check(String values[]);
    abstract int receipt_id_index();
    abstract String formatted_field_value(String fieldsLine);

    boolean isEmpty(String line) {
        return line == null;
    }

    int checkForReceipt(BufferedReader inputStream) throws NumberFormatException, IOException {
        String line;
        while(!isEmpty(line = inputStream.readLine())) {
            String values[] = line.split(" ", 3);
            if(receipt_check(values)) {
                int receiptId = Integer.parseInt(values[receipt_id_index()].trim());
                return receiptId;
            }
        }
        return -1;
    }

    String getValueOfField(String fieldsLine) throws WrongFileFormatException {
        if(isEmpty(fieldsLine))
            throw new WrongFileFormatException();
    
        try {
            return formatted_field_value(fieldsLine);
        }
        catch(NullPointerException e) {
            throw new WrongFileFormatException();
        }
    }

    public void readFile(String fileName) throws NumberFormatException, IOException, WrongTaxpayerStatusException, WrongFileFormatException, WrongReceiptKindException, WrongReceiptDateException {
        BufferedReader inputStream = new BufferedReader(new java.io.FileReader(fileName));
        String fullname = getValueOfField(inputStream.readLine());
        int taxRegistrationNumber = Integer.parseInt(getValueOfField(inputStream.readLine()));
        TaxpayerType status = TaxpayerType.from_string(getValueOfField(inputStream.readLine()));
        float income = Float.parseFloat(getValueOfField(inputStream.readLine()));

        Taxpayer new_taxpayer = TaxpayerFactory.create(status, fullname, taxRegistrationNumber, income);
        TaxpayerHashmap.put(taxRegistrationNumber, new_taxpayer);

        int receiptId;
        while((receiptId = checkForReceipt(inputStream)) > 0) {
            String issueDate = getValueOfField(inputStream.readLine());
            ReceiptKind kind = ReceiptKind.from_string(getValueOfField(inputStream.readLine()));
            float amount = Float.parseFloat(getValueOfField(inputStream.readLine()));
            String companyName = getValueOfField(inputStream.readLine());
            String country = getValueOfField(inputStream.readLine());
            String city = getValueOfField(inputStream.readLine());
            String street = getValueOfField(inputStream.readLine());
            int number = Integer.parseInt(getValueOfField(inputStream.readLine()));

            new_taxpayer.add_receipt(new Receipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number));
        }
    }
}
