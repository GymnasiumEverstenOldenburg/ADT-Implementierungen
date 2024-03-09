package tests.java;

import main.java.DynArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDynArray {

    DynArray<Integer> dynArray;

    @BeforeEach
    public void setup() {
        dynArray = new DynArray<>();
    }

    @Test
    @Order(1)
    public void testEmptyDynArray() {
        assertTrue(dynArray.isEmpty(), "New DynArray should be empty");
        assertEquals(0, dynArray.getLength(), "New DynArray should have length 0");
    }

    @Test
    @Order(2)
    public void testAppend() {
        dynArray.append(128);
        assertFalse(dynArray.isEmpty(), "DynArray should not be empty after appending an element");
        assertEquals(1, dynArray.getLength(), "DynArray length should be 1 after appending");
        assertEquals(128, dynArray.getItem(0), "Appended element should be at index 0");
    }

    @Test
    @Order(3)
    public void testInsertAt() {
        dynArray.append(128);
        dynArray.append(512);
        dynArray.insertAt(1, 256);

        assertEquals(3, dynArray.getLength(), "DynArray length should be 3 after inserting");
        assertEquals(128, dynArray.getItem(0), "First element should be unchanged");
        assertEquals(256, dynArray.getItem(1), "Element at index 1 should be 256 after insertion");
        assertEquals(512, dynArray.getItem(2), "Element at index 2 should be unchanged");
    }

    @Test
    @Order(4)
    public void testSetItem() {
        dynArray.append(5);
        dynArray.setItem(0, 1024);

        assertEquals(1, dynArray.getLength(), "DynArray length should be 1 after setting item");
        assertEquals(1024, dynArray.getItem(0), "Item at index 0 should be set to 1024");
    }

    @Test
    @Order(5)
    public void testDelete() {
        dynArray.append(256);
        dynArray.append(512);
        dynArray.delete(0);
        assertEquals(1, dynArray.getLength(), "DynArray length should be 1 after deletion");
        assertEquals(512, dynArray.getItem(0), "Element at index 0 should be the second element after deletion");
    }
}
