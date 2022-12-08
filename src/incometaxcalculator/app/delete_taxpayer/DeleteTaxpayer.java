package incometaxcalculator.app.delete_taxpayer;

import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;
import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.Taxpayer;
import incometaxcalculator.data.management.TaxpayerManager;

public class DeleteTaxpayer implements DeleteTaxpayerBoundary {
    TaxpayerManager manager;

    public DeleteTaxpayer(TaxpayerManager manager) {
        this.manager = manager;
    }

    @Override
    public void delete(int tax_registration_number) {
        Taxpayer taxpayer = this.manager.get_from_taxpayers(tax_registration_number);
        this.manager.remove_from_taxpayers(tax_registration_number);
        HashMap<Integer, Receipt> receiptsHashMap = taxpayer.getReceiptHashMap();
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();

        while(iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            this.manager.remove_from_receipts(receipt.getId());
        }
    }    
}
