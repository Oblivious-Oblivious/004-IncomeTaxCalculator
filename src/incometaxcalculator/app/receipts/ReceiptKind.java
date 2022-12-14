package incometaxcalculator.app.receipts;

import incometaxcalculator.app.exceptions.WrongReceiptKindException;

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

    public static ReceiptKind from_string(String value) throws WrongReceiptKindException {
        for(ReceiptKind kind : values())
            if(value.equals(kind.toString()))
                return kind;
        throw new WrongReceiptKindException();
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(ReceiptKind other) {
        return this.value.equals(other.value);
    }
}
