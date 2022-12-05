import jspec.*;
import load_taxpayer.*;

public class TestRunner {
    public static void main(String args[]) {
        SpecModule modules[] = {
            new UC1(),
        };
        Spec s = new Spec(modules);
        s.run_spec_suite("all");
    }
}
