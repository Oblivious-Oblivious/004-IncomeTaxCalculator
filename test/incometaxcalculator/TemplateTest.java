package incometaxcalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemplateTest {
    @Test
    public void template() {
        assertEquals(42, 42);
        assertNotEquals(42, 41);
        assertArrayEquals(new int[]{}, new int[]{});
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertNotNull(42);
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }
}
