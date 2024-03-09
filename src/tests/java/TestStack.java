package tests.java;

import main.java.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStack {

    Stack<Integer> stack;

    @BeforeEach
    public void setup() {
        stack = new Stack<>();
    }

    @Test
    @Order(1)
    public void testEmptyStack() {
        assertTrue(stack.isEmpty(), "New Stack should be empty");
        assertThrows(IllegalArgumentException.class, () -> stack.top(), "Getting top of empty Stack should throw an exception");
    }

    @Test
    @Order(2)
    public void testPush() {
        stack.push(128);
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an element");
        assertEquals(128, stack.top(), "Pushed element should be at the top of the Stack");
    }

    @Test
    @Order(3)
    public void testPop() {
        stack.push(128);
        stack.push(256);

        assertEquals(256, stack.pop(), "Popped element should be the last element pushed");
        assertEquals(128, stack.top(), "Top of Stack should be updated after pop");
        assertFalse(stack.isEmpty(), "Stack should not be empty after pop");
    }

    @Test
    @Order(4)
    public void testPushPopSequence() {
        stack.push(128);
        stack.push(256);
        stack.push(512);

        assertEquals(512, stack.pop(), "Popped element should be the last element pushed");
        assertEquals(256, stack.top(), "Top of Stack should be updated after pop");
        assertFalse(stack.isEmpty(), "Stack should not be empty after pop");

        stack.push(1024);
        assertEquals(1024, stack.top(), "Top of Stack should be the last element pushed after the push");
    }
}
