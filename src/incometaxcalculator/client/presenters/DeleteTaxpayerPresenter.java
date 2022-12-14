package incometaxcalculator.client.presenters;

import incometaxcalculator.app.delete_taxpayer.DeleteTaxpayer;
import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;

public class DeleteTaxpayerPresenter {
    public static String delete(String trn) {        
        DeleteTaxpayerBoundary deleter = new DeleteTaxpayer();
        if(deleter.taxpayer_hashmap_is_not_empty()) {
            try {
                int tax_registration_number = Integer.parseInt(trn);
                if(deleter.contains_taxpayer(tax_registration_number))
                    deleter.delete(tax_registration_number);
                return "";
            }
            catch(NumberFormatException e) {
                return "Adress number is not a valid number.";
            }
        }
        else {
            return "There isn't any taxpayer loaded. Please load one first.";
        }
    }
}
