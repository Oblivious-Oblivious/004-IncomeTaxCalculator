package incometaxcalculator.app.save_data;

import java.io.IOException;

// TODO Implement into factory
public abstract class LogWriter {
    // TODO Abstact common export formats
    public abstract void generateFile(int taxRegistrationNumber) throws IOException;
}
