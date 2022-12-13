package incometaxcalculator.app.save_data;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.app.taxpayers.Taxpayer;

public abstract class LogWriter {
    Taxpayer taxpayer;

    abstract String get_type();
    abstract String name();
    abstract String afm();
    abstract String income();
    abstract String basic_tax();
    abstract String tax_increase();
    abstract String tax_decrease();
    abstract String total_tax();
    abstract String total_receipts_gathered();
    abstract String entertainment();
    abstract String basic();
    abstract String travel();
    abstract String health();
    abstract String other();

    public void write_log() throws IOException {
        PrintWriter output_stream = new PrintWriter(new java.io.FileWriter(taxpayer.tax_registration_number + get_type()));
        output_stream.println(name());
        output_stream.println(afm());
        output_stream.println(income());
        output_stream.println(basic_tax());
        if(this.taxpayer.get_variation_tax_on_receipts() > 0)
            output_stream.println(tax_increase());
        else
            output_stream.println(tax_decrease());        
        output_stream.println(total_tax());
        output_stream.println(total_receipts_gathered());
        output_stream.println(entertainment());
        output_stream.println(basic());
        output_stream.println(travel());
        output_stream.println(health());
        output_stream.println(other());

        output_stream.close();
    }
}
