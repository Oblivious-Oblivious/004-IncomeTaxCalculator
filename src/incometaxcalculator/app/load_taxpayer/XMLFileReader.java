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
    String formatted_field_value(String fieldsLine) {
        String valueWithTail[] = fieldsLine.split(" ", 2);
        String valueReversed[] = new StringBuilder(valueWithTail[1]).reverse().toString().trim().split(" ", 2);
        return new StringBuilder(valueReversed[1]).reverse().toString();
    }
}
