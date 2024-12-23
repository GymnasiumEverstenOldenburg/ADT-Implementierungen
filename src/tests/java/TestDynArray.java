package tests.java;

import main.java.DynArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDynArray {

    DynArray<Integer> dynArray;

    @BeforeEach
    public void setup() {
        dynArray = new DynArray<>();
    }

    @Test
    public void testEmptyDynArray() {
        assertTrue(dynArray.isEmpty(), "New DynArray should be empty");
        assertEquals(0, dynArray.getLength(), "New DynArray should have length 0");
    }

    @Test
    public void testAppend() {
        dynArray.append(128);
        assertFalse(dynArray.isEmpty(), "DynArray should not be empty after appending an element");
        assertEquals(1, dynArray.getLength(), "DynArray length should be 1 after appending");
        assertEquals(128, dynArray.getItem(0), "Appended element should be at index 0");
    }

    @Test
    public void testInsertAt() {
        assertThrows(IllegalArgumentException.class, () -> dynArray.insertAt(-1, 100), "insertAt should throw exception when using invalid index");
        assertThrows(IllegalArgumentException.class, () -> dynArray.insertAt(1, 100));

        dynArray.append(128);
        dynArray.append(512);
        
        assertThrows(IllegalArgumentException.class, () -> dynArray.insertAt(-1, 100));
        assertThrows(IllegalArgumentException.class, () -> dynArray.insertAt(3, 100));
        
        dynArray.insertAt(1, 256);

        assertEquals(3, dynArray.getLength(), "DynArray length should be 3 after inserting");
        assertEquals(128, dynArray.getItem(0), "First element should be unchanged");
        assertEquals(256, dynArray.getItem(1), "Element at index 1 should be 256 after insertion");
        assertEquals(512, dynArray.getItem(2), "Element at index 2 should be unchanged");
    }

    @Test
    public void testInsertAtZero() {
        dynArray.insertAt(0, 32);

        assertEquals(1, dynArray.getLength(), "DynArray length should be 1 after inserting");
        assertEquals(32, dynArray.getItem(0), "First element should be unchanged");
        
        // test insertion at index 0 when array not empty
        dynArray.insertAt(0, 32);
        assertEquals(2, dynArray.getLength(), "DynArray length should be 2 after inserting");
    }

    @Test
    public void testSetItem() {
        dynArray.append(5);
        dynArray.setItem(0, 1024);

        assertEquals(1, dynArray.getLength(), "DynArray length should be 1 after setting item");
        assertEquals(1024, dynArray.getItem(0), "Item at index 0 should be set to 1024");
    }

    @Test
    public void testDeleteFirst() {
        assertThrows(IllegalArgumentException.class, () -> dynArray.delete(123), "delete should throw exception when used on empty DynArray");
        
        dynArray.append(256);
        dynArray.append(512);
        dynArray.delete(0);
        
        assertEquals(1, dynArray.getLength(), "DynArray length should be 1 after deletion");
        assertEquals(512, dynArray.getItem(0), "Element at index 0 should be the second element after deletion");
    }

    @Test
    public void testDeleteLast() {
        dynArray.append(256);
        dynArray.append(512);
        dynArray.append(1024);
        dynArray.delete(3 - 1); // delete last element

        assertEquals(2, dynArray.getLength(), "DynArray length should be 2 after deletion");
        assertEquals(512, dynArray.getItem(1), "Element at index 1 should still be 512");
    }

    @Test
    public void testDeleteMiddle() {
        dynArray.append(256);
        dynArray.append(512);
        dynArray.append(1024);
        dynArray.delete(1); // delete last element

        assertEquals(2, dynArray.getLength(), "DynArray length should be 2 after deletion");
        assertEquals(256, dynArray.getItem(0), "Element at index 0 should still be 256");
        assertEquals(1024, dynArray.getItem(1), "Element at index 1 should now be 1024");
    }
}
