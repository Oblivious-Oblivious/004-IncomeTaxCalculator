package incometaxcalculator.app.view_report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.app.SpecHelper;

public class ViewReportTest {
    @Before public void before_each() {
        SpecHelper.clear_taxpayer_hashmap();
        SpecHelper.setup_taxpayer_hashmap();
    }

    @Test public void tests_produce_report_with_valid_data() {
        // TODO Implement
    }

    @After public void after_each() {
        SpecHelper.clear_taxpayer_hashmap();
    }
}
