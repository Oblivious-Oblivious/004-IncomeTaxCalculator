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
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxpayer.tax_registration_number + get_type()));
        outputStream.println(name());
        outputStream.println(afm());
        outputStream.println(income());
        outputStream.println(basic_tax());
        if(this.taxpayer.get_variation_tax_on_receipts() > 0)
            outputStream.println(tax_increase());
        else
            outputStream.println(tax_decrease());        
        outputStream.println(total_tax());
        outputStream.println(total_receipts_gathered());
        outputStream.println(entertainment());
        outputStream.println(basic());
        outputStream.println(travel());
        outputStream.println(health());
        outputStream.println(other());

        outputStream.close();
    }
}
