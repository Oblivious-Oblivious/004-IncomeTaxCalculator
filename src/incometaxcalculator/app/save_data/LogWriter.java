package incometaxcalculator.app.save_data;

import java.io.IOException;

// TODO Implement into factory
public abstract class LogWriter {
    short ENTERTAINMENT = 0;
    short BASIC = 1;
    short TRAVEL = 2;
    short HEALTH = 3;
    short OTHER = 4;

    // TODO Abstact common export formats
    public abstract void generateFile(int taxRegistrationNumber) throws IOException;
}
