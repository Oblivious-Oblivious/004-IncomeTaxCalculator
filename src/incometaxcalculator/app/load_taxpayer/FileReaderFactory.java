package incometaxcalculator.app.load_taxpayer;

import incometaxcalculator.app.exceptions.WrongFileEndingException;

public class FileReaderFactory {
    public static FileReader create(FileReaderType type) throws WrongFileEndingException {
        switch(type) {
            case TXT:
                return new TXTFileReader();
            case XML:
                return new XMLFileReader();
            default:
                throw new WrongFileEndingException();
        }
    }
}
