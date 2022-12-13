package incometaxcalculator.app.load_taxpayer;

public class XMLFileReader extends FileReader {
    @Override
    boolean receipt_check(String values[]) {
        return values[0].equals("<ReceiptID>");
    }

    @Override
    int receipt_id_index() {
        return 1;
    }

    @Override
    String formatted_field_value(String fields_line) {
        String value_with_tail[] = fields_line.split(" ", 2);
        String value_reversed[] = new StringBuilder(value_with_tail[1]).reverse().toString().trim().split(" ", 2);
        return new StringBuilder(value_reversed[1]).reverse().toString();
    }
}
