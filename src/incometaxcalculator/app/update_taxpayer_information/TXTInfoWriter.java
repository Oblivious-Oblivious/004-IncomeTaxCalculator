package incometaxcalculator.app.update_taxpayer_information;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class TXTInfoWriter extends InfoWriter {
    public TXTInfoWriter(int taxRegistrationNumber) {
        this.taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);
    }

    @Override
    String get_type() {
        return "_INFO.txt";
    }

    String name() { return "Name: " + this.taxpayer.fullname; }
    String afm() { return "AFM: " + this.taxpayer.taxRegistrationNumber; }
    String status() { return "Status: " + this.taxpayer; }
    String income() { return "Income: " + this.taxpayer.income; }
    String receipts() { return "Receipts:"; }

    String id_of(Receipt receipt) { return "Receipt ID: " + receipt.id; }
    String date_of(Receipt receipt) { return "Date: " + receipt.issueDate; }
    String kind_of(Receipt receipt) { return "Kind: " + receipt.kind; }
    String amount_of(Receipt receipt) { return "Amount: " + receipt.amount; }
    String company_of(Receipt receipt) { return "Company: " + receipt.company.name; }
    String country_of(Receipt receipt) { return "Country: " + receipt.company.address.country; }
    String city_of(Receipt receipt) { return "City: " + receipt.company.address.city; }
    String street_of(Receipt receipt) { return "Street: " + receipt.company.address.street; }
    String number_of(Receipt receipt) { return "Number: " + receipt.company.address.number; }
}
