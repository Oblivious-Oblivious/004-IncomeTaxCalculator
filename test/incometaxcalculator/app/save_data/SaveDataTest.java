package incometaxcalculator.app.save_data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.app.SpecHelper;

public class SaveDataTest {
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
