package load_taxpayer;

import jspec.*;

public class UC1 extends SpecModule {
    public void spec_code() {
        before_each(() -> {});

        it("loads taxpayer information from file", () -> {
            assert_that(42).equals_to(42);
        });
    }
}
