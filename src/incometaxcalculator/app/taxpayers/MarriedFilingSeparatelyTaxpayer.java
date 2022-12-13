package incometaxcalculator.app.taxpayers;

public class MarriedFilingSeparatelyTaxpayer extends Taxpayer {
    public MarriedFilingSeparatelyTaxpayer(String fullname, int tax_registration_number, float income) {
        super(fullname, tax_registration_number, income);
    }

    @Override
    public int[] get_income_bounds() {
        return new int[] {18040, 71680, 90000, 127120};
    }

    @Override
    public double[] get_tax_multipliers() {
        return new double[] {965.14, 4746.76, 6184.88, 9098.80};
    }

    public String toString() {
        return "Married Filing Separately";
    }
}
