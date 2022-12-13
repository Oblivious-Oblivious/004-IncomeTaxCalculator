package incometaxcalculator.app.taxpayers;

public class MarriedFilingJointlyTaxpayer extends Taxpayer {
    public MarriedFilingJointlyTaxpayer(String fullname, int tax_registration_number, float income) {
        super(fullname, tax_registration_number, income);
    }

    @Override
    public int[] get_income_bounds() {
        return new int[] {36080, 90000, 143350, 254240};
    }

    @Override
    public double[] get_tax_multipliers() {
        return new double[] {1930.28, 5731.64, 9492.82, 18197.69};
    }

    public String toString() {
        return "Married Filing Jointly";
    }
}
