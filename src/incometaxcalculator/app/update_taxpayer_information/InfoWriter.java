package incometaxcalculator.app.update_taxpayer_information;

import java.io.IOException;

// TODO Implement into factory
public abstract class InfoWriter {
    public abstract void generateFile(int taxRegistrationNumber) throws IOException;
}
