package incometaxcalculator.app.taxpayers;

import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;

public class TaxpayerFactory {
    public static Taxpayer create(TaxpayerType status, String fullname, int tax_registration_number, float income) throws WrongTaxpayerStatusException {
        switch(status) {
            case MARRIED_FILING_JOINTLY:
                return new MarriedFilingJointlyTaxpayer(fullname, tax_registration_number, income);
            case MARRIED_FILING_SEPARATELY:
                return new MarriedFilingSeparatelyTaxpayer(fullname, tax_registration_number, income);
            case SINGLE:
                return new SingleTaxpayer(fullname, tax_registration_number, income);
            case HEAD_OF_HOUSEHOLD:
                return new HeadOfHouseholdTaxpayer(fullname, tax_registration_number, income);
            default:
                throw new WrongTaxpayerStatusException();
        }
    }
}
