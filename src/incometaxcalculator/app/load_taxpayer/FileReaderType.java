package incometaxcalculator.app.load_taxpayer;

public enum FileReaderType {
    TXT("txt"),
    XML("xml");

    String value;

    FileReaderType(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
