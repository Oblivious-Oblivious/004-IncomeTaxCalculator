package incometaxcalculator.app.save_data;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;

public abstract class LogWriter {
    Taxpayer taxpayer;

    abstract String get_type();
    abstract String[] get_label_format();

    String name() { return this.taxpayer.fullname; }
    int afm() { return this.taxpayer.taxRegistrationNumber; }
    float income() { return this.taxpayer.income; }
    double basicTax() { return this.taxpayer.getBasicTax(); }
    double variationTaxOnReceipts() { return this.taxpayer.getVariationTaxOnReceipts(); }
    double totalTax() { return this.taxpayer.getTotalTax(); }
    int totalReceiptsGathered() { return this.taxpayer.totalReceiptsGathered; }
    double entertainment() { return this.taxpayer.getAmountOfReceiptKind(ReceiptKind.ENTERTAINMENT); }
    double basic() { return this.taxpayer.getAmountOfReceiptKind(ReceiptKind.BASIC); }
    double travel() { return this.taxpayer.getAmountOfReceiptKind(ReceiptKind.TRAVEL); }
    double health() { return this.taxpayer.getAmountOfReceiptKind(ReceiptKind.HEALTH); }
    double other() { return this.taxpayer.getAmountOfReceiptKind(ReceiptKind.OTHER); }

    public void generateFile() throws IOException {
        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxpayer.taxRegistrationNumber + get_type()));
        String[] labels = get_label_format();
        for(String label : labels)
            outputStream.println(label);
        outputStream.close();
    }
}
