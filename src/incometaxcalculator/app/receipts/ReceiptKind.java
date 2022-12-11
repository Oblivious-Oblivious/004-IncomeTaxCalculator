package incometaxcalculator.app.receipts;

public enum ReceiptKind {
    ENTERTAINMENT("Entertainment"),
    BASIC("Basic"),
    TRAVEL("Travel"),
    HEALTH("Health"),
    OTHER("Other");

    String value;

    ReceiptKind(String value) {
        this.value = value;
    }

    public static ReceiptKind from_string(String value) {
        for(ReceiptKind kind : values())
            if(value.equals(kind.toString()))
                return kind;
        return ReceiptKind.OTHER;
    }

    public String toString() {
        return this.value;
    }
}
