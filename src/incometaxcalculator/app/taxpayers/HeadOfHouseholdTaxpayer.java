package incometaxcalculator.app.taxpayers;

public class HeadOfHouseholdTaxpayer extends Taxpayer {
    public HeadOfHouseholdTaxpayer(String fullname, int taxRegistrationNumber, float income) {
        super(fullname, taxRegistrationNumber, income);
    }

    @Override
    public int[] get_income_bounds() {
        return new int[] {30390, 90000, 122110, 203390};
    }

    @Override
    public double[] get_tax_multipliers() {
        return new double[] {1625.87, 5828.38, 8092.13, 14472.61};
    }

    public String toString() {
        return "Head of Household";
    }
}
