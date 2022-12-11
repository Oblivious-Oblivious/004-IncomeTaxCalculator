package incometaxcalculator.app.taxpayers;

import incometaxcalculator.app.exceptions.WrongTaxpayerStatusException;

public class TaxpayerFactory {
    public static Taxpayer create(TaxpayerType status, String fullname, int taxRegistrationNumber, float income) throws WrongTaxpayerStatusException {
        switch(status) {
            case MARRIED_FILING_JOINTLY:
                return new MarriedFilingJointlyTaxpayer(fullname, taxRegistrationNumber, income);
            case MARRIED_FILING_SEPARATELY:
                return new MarriedFilingSeparatelyTaxpayer(fullname, taxRegistrationNumber, income);
            case SINGLE:
                return new SingleTaxpayer(fullname, taxRegistrationNumber, income);
            case HEAD_OF_HOUSEHOLD:
                return new HeadOfHouseholdTaxpayer(fullname, taxRegistrationNumber, income);
            default:
                throw new WrongTaxpayerStatusException();
        }
    }
}
