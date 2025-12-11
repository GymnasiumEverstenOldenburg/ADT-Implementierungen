package tests.java;

import main.java.BinTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBinTree {

    private BinTree<Integer> tree;

    @BeforeEach
    public void setup() {
        tree = new BinTree<>();
    }

    @Test
    @Order(1)
    public void testEmptyTree() {
        assertTrue(tree.isEmpty(), "New tree should be empty");
        assertNull(tree.getItem(), "Empty tree's item should be null");
        assertFalse(tree.isLeaf(), "Empty tree should not be a leaf");
    }

    
    @Test
    @Order(2)
    public void testSetItem() {
        tree.setItem(128);
        assertFalse(tree.isEmpty(), "Tree shouldn't be empty anymore");
        assertTrue(tree.getLeft() != null && tree.getLeft().isEmpty(), "Left tree should now be empty tree");
        assertTrue(tree.getRight() != null && tree.getRight().isEmpty(), "Right tree should now be empty tree");
        assertEquals(128, tree.getItem(), "Tree's item should be 128");
        assertTrue(tree.isLeaf(), "Tree with empty child trees should be leaf");
    }
    
    @Test
    @Order(3)
    public void testDeleteItem() {
        assertFalse(tree.isLeaf(), "Tree shouldn't be leaf, as it is empty.");
        tree.setItem(128);
        tree.setItem(null);
        assertTrue(tree.isLeaf(), "Tree should still be leaf, as it still has empty child trees.");
        assertNull(tree.getItem(), "Tree's item should be deleted");
    }
    
    @Test
    @Order(4)
    public void testLeftAndRightChildren() {
        BinTree<Integer> leftChild = new BinTree<>(128);
        BinTree<Integer> rightChild = new BinTree<>(256);

        tree.setLeft(leftChild);
        tree.setRight(rightChild);

        assertNotNull(tree.getLeft(), "Tree should have a left child");
        assertEquals(leftChild, tree.getLeft(), "Tree's left child should be set");

        assertNotNull(tree.getRight(), "Tree should have a right child");
        assertEquals(rightChild, tree.getRight(), "Tree's right child should be set");

        assertFalse(tree.isLeaf(), "Tree with non-empty left and right children should not be a leaf");
    }


    @Test
    @Order(5)
    public void testDeleteLeftAndRight() {
        BinTree<Integer> leftChild = new BinTree<>(128);
        BinTree<Integer> rightChild = new BinTree<>(512);

        tree.setLeft(leftChild);
        tree.setRight(rightChild);

        tree.setLeft(null);
        assertNull(tree.getLeft(), "Tree's left child should be deleted");

        tree.setRight(null);
        assertNull(tree.getRight(), "Tree's right child should be deleted");

        assertFalse(tree.isLeaf(), "Tree with deleted left and right children should NOT be a leaf.");
    }

}
