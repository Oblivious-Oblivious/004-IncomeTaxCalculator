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
        PrintWriter output_stream = new PrintWriter(new java.io.FileWriter(this.taxpayer.tax_registration_number + get_type()));
        output_stream.println(name());
        output_stream.println(afm());
        output_stream.println(status());
        output_stream.println(income());
        output_stream.println();
        output_stream.println(receipts());
        output_stream.println();

        for(Receipt receipt : this.taxpayer.all_receipts()) {
            output_stream.println(id_of(receipt));
            output_stream.println(date_of(receipt));
            output_stream.println(kind_of(receipt));
            output_stream.println(amount_of(receipt));
            output_stream.println(company_of(receipt));
            output_stream.println(country_of(receipt));
            output_stream.println(city_of(receipt));
            output_stream.println(street_of(receipt));
            output_stream.println(number_of(receipt));
            output_stream.println();
        }

        output_stream.close();
    }
}
