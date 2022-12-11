package incometaxcalculator.app.taxpayers;

import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;

public class TaxpayerFactory {
    // TODO Maybe implement this with type enum
    public static Taxpayer create(String status, String fullname, int taxRegistrationNumber, float income) throws WrongTaxpayerStatusException {
        switch(status) {
            case "Married Filing Jointly":
                return new MarriedFilingJointlyTaxpayer(fullname, taxRegistrationNumber, income);
            case "Married Filing Separately":
                return new MarriedFilingSeparatelyTaxpayer(fullname, taxRegistrationNumber, income);
            case "Single":
                return new SingleTaxpayer(fullname, taxRegistrationNumber, income);
            case "Head of Household":
                return new HeadOfHouseholdTaxpayer(fullname, taxRegistrationNumber, income);
            default:
                throw new WrongTaxpayerStatusException();
        }
    }
}
