package incometaxcalculator.app.taxpayers;

public class SingleTaxpayer extends Taxpayer {
    public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
        super(fullname, taxRegistrationNumber, income);
    }

    @Override
    public int[] get_income_bounds() {
        return new int[] {24680, 81080, 90000, 152540};
    }

    @Override
    public double[] get_tax_multipliers() {
        return new double[] {1320.38, 5296.58, 5996.80, 10906.19};
    }

    public String toString() {
        return "Single";
    }
}
