package incometaxcalculator.app.update_taxpayer_information;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;

public abstract class InfoWriter {
    Taxpayer taxpayer;

    abstract String get_type();
    abstract String name();
    abstract String afm();
    abstract String status();
    abstract String income();
    abstract String receipts();
    abstract String id_of(Receipt receipt);
    abstract String date_of(Receipt receipt);
    abstract String kind_of(Receipt receipt);
    abstract String amount_of(Receipt receipt);
    abstract String company_of(Receipt receipt);
    abstract String country_of(Receipt receipt);
    abstract String city_of(Receipt receipt);
    abstract String street_of(Receipt receipt);
    abstract String number_of(Receipt receipt);

    public void write_info() throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(this.taxpayer.tax_registration_number + get_type()));
        outputStream.println(name());
        outputStream.println(afm());
        outputStream.println(status());
        outputStream.println(income());
        outputStream.println();
        outputStream.println(receipts());
        outputStream.println();

        for(Receipt receipt : this.taxpayer.all_receipts()) {
            outputStream.println(id_of(receipt));
            outputStream.println(date_of(receipt));
            outputStream.println(kind_of(receipt));
            outputStream.println(amount_of(receipt));
            outputStream.println(company_of(receipt));
            outputStream.println(country_of(receipt));
            outputStream.println(city_of(receipt));
            outputStream.println(street_of(receipt));
            outputStream.println(number_of(receipt));
            outputStream.println();
        }

        outputStream.close();
    }
}
