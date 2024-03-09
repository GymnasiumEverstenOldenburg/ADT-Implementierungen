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
        assertFalse(tree.hasItem(), "Empty tree should not have an item");
        assertNull(tree.getItem(), "Empty tree's item should be null");
        assertTrue(tree.isLeaf(), "Empty tree should be a leaf");
    }

    @Test
    @Order(2)
    public void testSetItem() {
        tree.setItem(128);

        assertTrue(tree.hasItem(), "Tree should have an item after setting");
        assertEquals(128, tree.getItem(), "Tree's item should be set to 128");
        assertTrue(tree.isLeaf(), "Tree with only root should be a leaf");
    }

    @Test
    @Order(3)
    public void testDeleteItem() {
        tree.setItem(128);
        tree.deleteItem();

        assertFalse(tree.hasItem(), "Tree's item should be deleted");
        assertNull(tree.getItem(), "Tree's item should be null after deletion");
        assertTrue(tree.isLeaf(), "Tree with deleted item should be a leaf");
    }

    @Test
    @Order(4)
    public void testLeftAndRightChildren() {
        BinTree<Integer> leftChild = new BinTree<>(128);
        BinTree<Integer> rightChild = new BinTree<>(256);

        tree.setLeft(leftChild);
        tree.setRight(rightChild);

        assertTrue(tree.hasLeft(), "Tree should have a left child");
        assertEquals(leftChild, tree.getLeft(), "Tree's left child should be set");

        assertTrue(tree.hasRight(), "Tree should have a right child");
        assertEquals(rightChild, tree.getRight(), "Tree's right child should be set");

        assertFalse(tree.isLeaf(), "Tree with left and right children should not be a leaf");
    }

    @Test
    @Order(5)
    public void testDeleteLeftAndRight() {
        BinTree<Integer> leftChild = new BinTree<>(128);
        BinTree<Integer> rightChild = new BinTree<>(512);

        tree.setLeft(leftChild);
        tree.setRight(rightChild);

        tree.deleteLeft();
        assertFalse(tree.hasLeft(), "Tree's left child should be deleted");

        tree.deleteRight();
        assertFalse(tree.hasRight(), "Tree's right child should be deleted");

        assertTrue(tree.isLeaf(), "Tree with deleted left and right children should be a leaf");
    }
}
