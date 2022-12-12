package incometaxcalculator.app.save_data;

import incometaxcalculator.app.exceptions.WrongFileFormatException;

public class LogWriterFactory {
    public static LogWriter create(LogWriterType type, int tax_registration_number) throws WrongFileFormatException {
        switch(type) {
            case TXT:
                return new TXTLogWriter(tax_registration_number);
            case XML:
                return new XMLLogWriter(tax_registration_number);
            default:
                throw new WrongFileFormatException();
        }
    }
}
