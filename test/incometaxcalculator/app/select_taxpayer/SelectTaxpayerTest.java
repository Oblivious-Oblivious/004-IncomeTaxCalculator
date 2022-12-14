package incometaxcalculator.app.select_taxpayer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.app.SpecHelper;
import incometaxcalculator.app.taxpayers.SingleTaxpayer;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.SelectTaxpayerBoundary;

public class SelectTaxpayerTest {
    @Before public void before_each() {
        SpecHelper.clear_taxpayer_hashmap();
        SpecHelper.setup_taxpayer_hashmap();
    }

    @Test public void tests_load_with_valid() {
        SelectTaxpayerBoundary selector = new SelectTaxpayer();
        Taxpayer taxpayer = selector.select(100000001);

        assertTrue(taxpayer.equals(new SingleTaxpayer("dummy1", 100000001, 120000)));
    }

    @Test public void tests_load_with_non_existent_trn() {
        SelectTaxpayerBoundary selector = new SelectTaxpayer();
        Taxpayer taxpayer = selector.select(123456789);

        assertNull(taxpayer);
    }

    @Test public void tests_load_with_invalid_trn() {
        SelectTaxpayerBoundary selector = new SelectTaxpayer();
        Taxpayer taxpayer = selector.select(1000000000);

        assertNull(taxpayer);
    }

    @Test public void tests_load_with_no_taxpayer_loaded() {
        SpecHelper.clear_taxpayer_hashmap();
        SelectTaxpayerBoundary selector = new SelectTaxpayer();
        Taxpayer taxpayer = selector.select(1000000000);

        assertNull(taxpayer);
    }

    @After public void after_each() {
        SpecHelper.clear_taxpayer_hashmap();
    }
}
