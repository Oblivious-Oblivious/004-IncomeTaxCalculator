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
    abstract String basicTax();
    abstract String taxIncrease();
    abstract String taxDecrease();
    abstract String totalTax();
    abstract String totalReceiptsGathered();
    abstract String entertainment();
    abstract String basic();
    abstract String travel();
    abstract String health();
    abstract String other();

    public void generateFile() throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxpayer.taxRegistrationNumber + get_type()));
        outputStream.println(name());
        outputStream.println(afm());
        outputStream.println(income());
        outputStream.println(basicTax());
        if(this.taxpayer.getVariationTaxOnReceipts() > 0)
            outputStream.println(taxIncrease());
        else
            outputStream.println(taxDecrease());        
        outputStream.println(totalTax());
        outputStream.println(totalReceiptsGathered());
        outputStream.println(entertainment());
        outputStream.println(basic());
        outputStream.println(travel());
        outputStream.println(health());
        outputStream.println(other());

        outputStream.close();
    }
}
