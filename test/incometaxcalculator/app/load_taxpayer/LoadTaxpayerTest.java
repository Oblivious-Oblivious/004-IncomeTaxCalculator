package incometaxcalculator.app.load_taxpayer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.app.SpecHelper;

public class LoadTaxpayerTest {
    @Before public void before_each() {
        SpecHelper.clear_taxpayer_hashmap();
        SpecHelper.setup_taxpayer_hashmap();
    }

    @Test public void tests_load_with_valid() {
        // TODO Implement
    }

    @After public void after_each() {
        SpecHelper.clear_taxpayer_hashmap();
    }
}
