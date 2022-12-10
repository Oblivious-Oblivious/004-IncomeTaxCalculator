package incometaxcalculator.app.delete_taxpayer;

import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerManager;
import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.taxpayers.Taxpayer;

public class DeleteTaxpayer implements DeleteTaxpayerBoundary {
    @Override
    public void delete(int tax_registration_number) {
        Taxpayer taxpayer = TaxpayerManager.taxpayerHashMap.get(tax_registration_number);
        TaxpayerManager.taxpayerHashMap.remove(tax_registration_number);
        HashMap<Integer, Receipt> receiptsHashMap = taxpayer.getReceiptHashMap();
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();

        while(iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            TaxpayerManager.receiptOwnerTRN.remove(receipt.id);
        }
    }    
}
