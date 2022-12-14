package incometaxcalculator.app.add_receipt;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.app.SpecHelper;
import incometaxcalculator.app.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;
import incometaxcalculator.app.receipts.Receipt;
import incometaxcalculator.app.receipts.ReceiptKind;
import incometaxcalculator.app.taxpayers.Taxpayer;
import incometaxcalculator.boundaries.AddReceiptBoundary;
import incometaxcalculator.persistence.TaxpayerHashmap;

public class AddReceiptTest {
    @Before public void before_each() {
        SpecHelper.clear_taxpayer_hashmap();
        SpecHelper.setup_taxpayer_hashmap();
    }

    @Test public void tests_add_receipt_with_valid_data() throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        AddReceiptBoundary adder = new AddReceipt();
        adder.add(2, "2/2/2022", 1234.0f, ReceiptKind.BASIC, "company1", "country1", "city1", "street1", 1, 100000000);

        Taxpayer t = TaxpayerHashmap.get(100000000);
        Receipt r = t.get(2);

        assertTrue(r.equals(new Receipt(2, "2/2/2022", 1234.0f, ReceiptKind.BASIC, "company1", "country1", "city1", "street1", 1)));
    }

    @Test public void tests_add_receipt_with_existing_id() throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        AddReceiptBoundary adder = new AddReceipt();
        adder.add(2, "2/2/2022", 1234.0f, ReceiptKind.BASIC, "company1", "country1", "city1", "street1", 1, 100000000);

        assertThrows(ReceiptAlreadyExistsException.class, () -> {
            adder.add(2, "2/2/2022", 1234.0f, ReceiptKind.BASIC, "company1", "country1", "city1", "street1", 1, 100000000);
        });
    }

    @Test public void tests_add_receipt_with_invalid_date() throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        AddReceiptBoundary adder = new AddReceipt();

        assertThrows(WrongReceiptDateException.class, () -> {
            adder.add(2, "wrong date", 1234.0f, ReceiptKind.BASIC, "company1", "country1", "city1", "street1", 1, 100000000);
        });
    }

    @Test public void tests_add_receipt_with_invalid_kind() throws IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        AddReceiptBoundary adder = new AddReceipt();

        assertThrows(WrongReceiptKindException.class, () -> {
            ReceiptKind kind = ReceiptKind.from_string("invalid kind");
            adder.add(2, "2/2/2022", 1234.0f, kind, "company1", "country1", "city1", "street1", 1, 100000000);
        });
    }

    @After public void after_each() {
        SpecHelper.clear_taxpayer_hashmap();
    }
}
