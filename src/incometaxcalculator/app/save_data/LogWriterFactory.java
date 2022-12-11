package incometaxcalculator.app.save_data;

import incometaxcalculator.app.exceptions.WrongFileFormatException;

public class LogWriterFactory {
    public static LogWriter create(LogWriterType type) throws WrongFileFormatException {
        switch(type) {
            case TXT:
                return new TXTLogWriter();
            case XML:
                return new XMLLogWriter();
            default:
                throw new WrongFileFormatException();
        }
    }
}
