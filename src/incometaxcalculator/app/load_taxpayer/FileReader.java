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
    abstract String formatted_field_value(String fields_line);

    boolean is_empty(String line) {
        return line == null;
    }

    int check_for_receipt(BufferedReader input_stream) throws NumberFormatException, IOException {
        String line;
        while(!is_empty(line = input_stream.readLine())) {
            String values[] = line.split(" ", 3);
            if(receipt_check(values))
                return Integer.parseInt(values[receipt_id_index()].trim());
        }
        return -1;
    }

    String get_value_of_field(String fields_line) throws WrongFileFormatException {
        if(is_empty(fields_line))
            throw new WrongFileFormatException();
    
        try {
            return formatted_field_value(fields_line);
        }
        catch(NullPointerException e) {
            throw new WrongFileFormatException();
        }
    }

    public void read_file(String filename) throws NumberFormatException, IOException, WrongTaxpayerStatusException, WrongFileFormatException, WrongReceiptKindException, WrongReceiptDateException {
        BufferedReader input_stream = new BufferedReader(new java.io.FileReader(filename));
        String fullname = get_value_of_field(input_stream.readLine());
        int tax_registration_number = Integer.parseInt(get_value_of_field(input_stream.readLine()));
        TaxpayerType status = TaxpayerType.from_string(get_value_of_field(input_stream.readLine()));
        float income = Float.parseFloat(get_value_of_field(input_stream.readLine()));

        Taxpayer new_taxpayer = TaxpayerFactory.create(status, fullname, tax_registration_number, income);
        TaxpayerHashmap.put(tax_registration_number, new_taxpayer);

        int receipt_id;
        while((receipt_id = check_for_receipt(input_stream)) > 0) {
            String date = get_value_of_field(input_stream.readLine());
            ReceiptKind kind = ReceiptKind.from_string(get_value_of_field(input_stream.readLine()));
            float amount = Float.parseFloat(get_value_of_field(input_stream.readLine()));
            String company_name = get_value_of_field(input_stream.readLine());
            String country = get_value_of_field(input_stream.readLine());
            String city = get_value_of_field(input_stream.readLine());
            String street = get_value_of_field(input_stream.readLine());
            int number = Integer.parseInt(get_value_of_field(input_stream.readLine()));

            new_taxpayer.add_receipt(new Receipt(receipt_id, date, amount, kind, company_name, country, city, street, number));
        }
    }
}
