package incometaxcalculator.app.update_taxpayer_information;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class XMLInfoWriter extends InfoWriter {
    public XMLInfoWriter(int taxRegistrationNumber) {
        this.taxpayer = TaxpayerHashmap.get(taxRegistrationNumber);
    }

    @Override
    String get_type() {
        return "_INFO.xml";
    }

    String name() { return "<Name> " + this.taxpayer.fullname + " </Name>"; }
    String afm() { return "<AFM> " + this.taxpayer.taxRegistrationNumber + " </AFM>"; }
    String status() { return "<Status> " + this.taxpayer + " </Status>"; }
    String income() { return "<Income> " + this.taxpayer.income + " </Income>"; }
    String receipts() { return "<Receipts>"; }

    String id_of(Receipt receipt) { return "<ReceiptID> " + receipt.id + " </ReceiptID>"; }
    String date_of(Receipt receipt) { return "<Date> " + receipt.issueDate + " </Date>"; }
    String kind_of(Receipt receipt) { return "<Kind> " + receipt.kind + " </Kind>"; }
    String amount_of(Receipt receipt) { return "<Amount> " + receipt.amount + " </Amount>"; }
    String company_of(Receipt receipt) { return "<Company> " + receipt.company.name + " </Company>"; }
    String country_of(Receipt receipt) { return "<Country> " + receipt.company.address.country + " </Country>"; }
    String city_of(Receipt receipt) { return "<City> " + receipt.company.address.city + " </City>"; }
    String street_of(Receipt receipt) { return "<Street> " + receipt.company.address.street + " </Street>"; }
    String number_of(Receipt receipt) { return "<Number> " + receipt.company.address.number + " </Number>"; }
}
