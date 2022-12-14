package incometaxcalculator.app.delete_receipt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.app.SpecHelper;
import incometaxcalculator.app.add_receipt.AddReceipt;
import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.AddReceiptBoundary;
import incometaxcalculator.boundaries.DeleteReceiptBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class DeleteReceiptTest {
    @Before public void before_each() throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        SpecHelper.clear_taxpayer_hashmap();
        SpecHelper.setup_taxpayer_hashmap();

        AddReceiptBoundary adder = new AddReceipt();
        adder.add(1, "2/2/2022", 0.0f, ReceiptKind.BASIC, "", "", "", "", 1, 100000001);
        adder.add(2, "2/2/2022", 0.0f, ReceiptKind.BASIC, "", "", "", "", 1, 100000001);
        adder.add(3, "2/2/2022", 0.0f, ReceiptKind.BASIC, "", "", "", "", 1, 100000001);
    }

    @Test public void tests_delete_receipt_with_valid_data() throws IOException, WrongReceiptKindException {
        DeleteReceiptBoundary deleter = new DeleteReceipt();
        Taxpayer current_taxpayer = TaxpayerHashmap.get(100000001);

        assertEquals(current_taxpayer.all_receipts().size(), 3);
        deleter.delete(100000001, 2);
        assertEquals(current_taxpayer.all_receipts().size(), 2);
        deleter.delete(100000001, 3);
        assertEquals(current_taxpayer.all_receipts().size(), 1);
        deleter.delete(100000001, 1);
        assertEquals(current_taxpayer.all_receipts().size(), 0);
    }

    @Test public void tests_delete_receipt_with_invalid_id() throws IOException, WrongReceiptKindException {
        DeleteReceiptBoundary deleter = new DeleteReceipt();
        Taxpayer current_taxpayer = TaxpayerHashmap.get(100000001);

        assertThrows(NullPointerException.class, () -> {
            deleter.delete(100000001, 42);
        });
        assertEquals(current_taxpayer.all_receipts().size(), 3);
        deleter.delete(100000001, 3);
        assertEquals(current_taxpayer.all_receipts().size(), 2);
    }

    @After public void after_each() {
        SpecHelper.clear_taxpayer_hashmap();
    }
}
