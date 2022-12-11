package incometaxcalculator.app.taxpayers;

public enum TaxpayerType {
    SINGLE("Single"),
    HEAD_OF_HOUSEHOLD("Head of Household"),
    MARRIED_FILING_SEPARATELY("Married Filing Separately"),
    MARRIED_FILING_JOINTLY("Married Filing Jointly");

    String value;

    TaxpayerType(String value) {
        this.value = value;
    }

    public static TaxpayerType from_string(String value) {
        for(TaxpayerType kind : values())
            if(value.equals(kind.toString()))
                return kind;
        return TaxpayerType.SINGLE;
    }

    public String toString() {
        return this.value;
    }
}
