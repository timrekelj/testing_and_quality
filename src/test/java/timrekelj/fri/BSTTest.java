package timrekelj.fri;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;



public class BSTTest {

    private BST<String> bst;

    public BSTTest() {}

    @BeforeEach
    public void setUp() {
        bst = new BST<>();
    }

    // testi dodajanja
    @Test
    public void testAddOne() {
        bst.add("Test");
    }

    @Test
    public void testAddIdentical() {
        bst.add("Test");
        bst.add("Test");
    }

    @Test
    public void testAddMultiple() {
        bst.add("Test4");
        bst.add("Test2");
        bst.add("Test1");
        bst.add("Test3");
        bst.add("Test5");
    }

    // testi brisanja
    @Test
    public void testRemoveFirstEmpty() {
        assertThrows(java.util.NoSuchElementException.class, bst::removeFirst);
    }

    @Test
    public void testRemoveFirstOne() {
        bst.add("Test");
        assertEquals("Test", bst.removeFirst());
    }

    @Test
    public void testRemoveFirstMultiple() {
        bst.add("Test5");
        bst.add("Test2");
        bst.add("Test8");
        bst.add("Test0");
        bst.add("Test3");
        bst.add("Test7");
        bst.add("Test9");
        bst.add("Test1");
        bst.add("Test4");
        bst.add("Test6");
        assertEquals("Test5", bst.removeFirst());
        assertEquals("Test6", bst.removeFirst());
        assertEquals("Test7", bst.removeFirst());
        assertEquals("Test8", bst.removeFirst());
        assertEquals("Test9", bst.removeFirst());
    }

    @Test
    public void testGetFirstEmpty() {
        assertThrows(java.util.NoSuchElementException.class, bst::getFirst);
    }

    @Test
    public void testGetFirstOne() {
        bst.add("Test");
        assertEquals("Test", bst.getFirst());
    }

    @Test
    public void testGetFirstMultiple() {
        bst.add("Test1");
        assertEquals("Test1", bst.getFirst());
        bst.add("Test3");
        bst.add("Test2");
        assertEquals("Test1", bst.getFirst());
        assertEquals("Test1", bst.getFirst());
    }

    // testiranje metode za globino
    @Test
    public void testDepthEmpty() {
        assertEquals(0, bst.depth());
    }

    @Test
    public void testDepthOne() {
        bst.add("Test1");
        assertEquals(1, bst.depth());
    }

    @Test
    public void testDepthMultiple() {
        bst.add("Test1");
        assertEquals(1, bst.depth());
        bst.add("Test5");
        assertEquals(2, bst.depth());
        bst.add("Test2");
        assertEquals(3, bst.depth());
        bst.add("Test4");
        assertEquals(4, bst.depth());
        bst.add("Test3");
        assertEquals(5, bst.depth());
        bst.add("Test6");
        assertEquals(5, bst.depth());
        bst.add("Test8");
        assertEquals(5, bst.depth());
        bst.add("Test7");
        assertEquals(5, bst.depth());
    }

    // test metode size
    @Test
    public void testSizeEmpty() {
        assertEquals(0, bst.size());
    }

    @Test
    public void testSizeOne() {
        bst.add("Test");
        assertEquals(1, bst.size());
    }

    @Test
    public void testSizeMultiple() {
        assertEquals(0, bst.size());
        bst.add("Test");
        assertEquals(1, bst.size());
        bst.add("Test1");
        assertEquals(2, bst.size());
        bst.add("Test2");
        assertEquals(3, bst.size());
    }

    // test metode isEmpty
    @Test
    public void testIsEmptyEmpty() {
        assertTrue(bst.isEmpty());
    }

    @Test
    public void testIsEmptyOne() {
        bst.add("Test");
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testIsEmptyMultiple() {
        bst.add("Test");
        bst.add("Test1");
        bst.add("Test2");
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testRemove() {
        bst.add("Test5");
        bst.add("Test2");
        bst.add("Test8");
        bst.add("Test0");
        bst.add("Test3");
        bst.add("Test7");
        bst.add("Test9");
        bst.add("Test1");
        bst.add("Test4");
        bst.add("Test6");
        assertEquals(bst.remove("Test3"), "Test3");
        assertEquals(bst.size(), 9);
    }

    @Test
    public void testRemoveNotFound() {
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        assertThrows(java.util.NoSuchElementException.class, () -> bst.remove("Test"));
    }

    @Test
    public void testRemoveEmpty() {
        assertThrows(java.lang.NullPointerException.class, () -> bst.remove("Test"));
    }

    @Test
    public void testExists() {
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test1");
        bst.add("Test4");
        bst.add("Test2");
        assertTrue(bst.exists("Test2"));
    }

    @Test
    public void testExistsFalse() {
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        assertFalse(bst.exists("Test4"));
    }

    @Test
    public void testExistsEmpty() {
        assertFalse(bst.exists("Test"));
    }
}
