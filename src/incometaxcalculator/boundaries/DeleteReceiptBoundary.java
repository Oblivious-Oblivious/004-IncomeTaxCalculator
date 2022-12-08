package incometaxcalculator.boundaries;

import java.io.IOException;

import incometaxcalculator.app.exceptions.WrongReceiptKindException;

public interface DeleteReceiptBoundary {
    public void delete(int receipt_id) throws IOException, WrongReceiptKindException;
}
