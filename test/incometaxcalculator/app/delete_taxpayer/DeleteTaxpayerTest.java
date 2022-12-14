package incometaxcalculator.app.delete_taxpayer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.app.SpecHelper;
import incometaxcalculator.boundaries.DeleteTaxpayerBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class DeleteTaxpayerTest {
    @Before public void before_each() {
        SpecHelper.clear_taxpayer_hashmap();
        SpecHelper.setup_taxpayer_hashmap();
    }

    @Test public void tests_delete_with_valid_data() {
        DeleteTaxpayerBoundary deleter = new DeleteTaxpayer();
        assertEquals(TaxpayerHashmap.size(), 8);
        deleter.delete(100000001);
        assertEquals(TaxpayerHashmap.size(), 7);
        deleter.delete(100000002);
        assertEquals(TaxpayerHashmap.size(), 6);
        deleter.delete(100000003);
        assertEquals(TaxpayerHashmap.size(), 5);
        deleter.delete(100000004);
    }

    @Test public void tests_delete_without_any_taxpayers_loaded() {
        SpecHelper.clear_taxpayer_hashmap();

        DeleteTaxpayerBoundary deleter = new DeleteTaxpayer();
        assertEquals(TaxpayerHashmap.size(), 0);

        deleter.delete(100000001);
        assertEquals(TaxpayerHashmap.size(), 0);
        deleter.delete(123456789);
        assertEquals(TaxpayerHashmap.size(), 0);
    }

    @Test public void tests_delete_with_invalid_trn() {
        DeleteTaxpayerBoundary deleter = new DeleteTaxpayer();
        assertEquals(TaxpayerHashmap.size(), 8);
        deleter.delete(100000001);
        assertEquals(TaxpayerHashmap.size(), 7);
        
        deleter.delete(123456789);
        assertEquals(TaxpayerHashmap.size(), 7);
    }

    @After public void after_each() {
        SpecHelper.clear_taxpayer_hashmap();
    }
}
