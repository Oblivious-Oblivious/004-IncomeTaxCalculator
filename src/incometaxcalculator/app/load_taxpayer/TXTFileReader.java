package incometaxcalculator.app.load_taxpayer;

public class TXTFileReader extends FileReader {
    @Override
    boolean receipt_check(String values[]) {
        return values[0].equals("Receipt") && values[1].equals("ID:");
    }

    @Override
    int receipt_id_index() {
        return 2;
    }

    @Override
    String formatted_field_value(String fieldsLine) {
        String values[] = fieldsLine.split(" ", 2);
        values[1] = values[1].trim();
        return values[1];
    }
}
