package incometaxcalculator.app.update_taxpayer_information;

import java.io.IOException;
import java.util.HashMap;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.persistence.TaxpayerManager;

public abstract class InfoWriter {
    public abstract void generateFile(int taxRegistrationNumber) throws IOException;

    public String getTaxpayerName(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerName(taxRegistrationNumber);
    }

    public String getTaxpayerIncome(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerIncome(taxRegistrationNumber);
    }

    public String getTaxpayerStatus(int taxRegistrationNumber) {
        return new TaxpayerManager().getTaxpayerStatus(taxRegistrationNumber);
    }

    public HashMap<Integer, Receipt> getReceiptHashMap(int taxRegistrationNumber) {
        return new TaxpayerManager().getReceiptHashMap(taxRegistrationNumber);
    }

    public int getReceiptId(Receipt receipt) {
        return receipt.id;
    }

    public String getReceiptIssueDate(Receipt receipt) {
        return receipt.issueDate.toString();
    }

    public String getReceiptKind(Receipt receipt) {
        return receipt.kind;
    }

    public float getReceiptAmount(Receipt receipt) {
        return receipt.amount;
    }

    public String getCompanyName(Receipt receipt) {
        return receipt.company.name;
    }

    public String getCompanyCountry(Receipt receipt) {
        return receipt.company.address.country;
    }

    public String getCompanyCity(Receipt receipt) {
        return receipt.company.address.city;
    }

    public String getCompanyStreet(Receipt receipt) {
        return receipt.company.address.street;
    }

    public int getCompanyNumber(Receipt receipt) {
        return receipt.company.address.number;
    }
}
