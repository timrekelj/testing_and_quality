package timrekelj.fri;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;



public class PrioritetnaVrstaTest {

    private PrioritetnaVrsta<String> pv;

    public PrioritetnaVrstaTest() {}

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() {
        pv = new PrioritetnaVrsta<>(10);
    }

    @AfterEach
    public void tearDown() {
    }


    /** Test metod razreda <PrioritetnaVrsta> */

    // testi dodajanja
    @Test
    public void testAddOne() {
        pv.add("Test");
    }

    @Test
    public void testAddMultiple() {
        pv.add("Test1");
        pv.add("Test2");
    }

    @Test
    public void testAddOverflow() {
        pv = new PrioritetnaVrsta<>(2);
        pv.add("Test1");
        pv.add("Test2");
        pv.add("Test3");
    }

    // testi brisanja
    @Test
    public void testRemoveFirstEmpty() {
        assertThrows(java.util.NoSuchElementException.class, pv::removeFirst);
    }

    @Test
    public void testRemoveFirstOne() {
        pv.add("Test");
        assertEquals("Test", pv.removeFirst());
    }

    @Test
    public void testRemoveFirstMax100() {
        var pv100 = new PrioritetnaVrsta<>();
        pv100.add("Test5");
        pv100.add("Test8");
        pv100.add("Test0");
        pv100.add("Test2");
        pv100.add("Test6");
        pv100.add("Test1");
        pv100.add("Test9");
        pv100.add("Test4");
        pv100.add("Test7");
        pv100.add("Test3");
        assertEquals("Test9", pv100.removeFirst());
    }

    @Test
    public void testRemoveFirstMultiple() {
        pv.add("Test1");
        pv.add("Test5");
        pv.add("Test2");
        pv.add("Test4");
        pv.add("Test3");
        assertEquals("Test5", pv.removeFirst());
        assertEquals("Test4", pv.removeFirst());
        assertEquals("Test3", pv.removeFirst());
        assertEquals("Test2", pv.removeFirst());
        assertEquals("Test1", pv.removeFirst());
    }

    // metoda get
    @Test
    public void testGetFirstEmpty() {
        assertThrows(java.util.NoSuchElementException.class, pv::getFirst);
    }

    @Test
    public void testGetFirstOne() {
        pv.add("Test");
        assertEquals("Test", pv.getFirst());
    }

    @Test
    public void testGetFirstMultiple() {
        pv.add("Test1");
        assertEquals("Test1", pv.getFirst());
        pv.add("Test3");
        pv.add("Test2");
        assertEquals("Test3", pv.getFirst());
        assertEquals("Test3", pv.getFirst());
    }

    // testiranje metode za globino
    @Test
    public void testDepthEmpty() {
        assertEquals(0, pv.depth());
    }

    @Test
    public void testDepthOne() {
        pv.add("Test1");
        assertEquals(1, pv.depth());
    }

    @Test
    public void testDepthMultiple() {
        pv.add("Test1");
        assertEquals(1, pv.depth());
        pv.add("Test5");
        assertEquals(2, pv.depth());
        pv.add("Test2");
        assertEquals(2, pv.depth());
        pv.add("Test4");
        assertEquals(3, pv.depth());
        pv.add("Test3");
        assertEquals(3, pv.depth());
        pv.add("Test6");
        assertEquals(3, pv.depth());
        pv.add("Test8");
        assertEquals(3, pv.depth());
        pv.add("Test7");
        assertEquals(4, pv.depth());
    }

    // test metode size
    @Test
    public void testSizeEmpty() {
        assertEquals(0, pv.size());
    }

    @Test
    public void testSizeOne() {
        pv.add("Test");
        assertEquals(1, pv.size());
    }

    @Test
    public void testSizeMultiple() {
        assertEquals(0, pv.size());
        pv.add("Test");
        assertEquals(1, pv.size());
        pv.add("Test1");
        assertEquals(2, pv.size());
        pv.add("Test2");
        assertEquals(3, pv.size());
    }

    // test metode isEmpty
    @Test
    public void testIsEmptyEmpty() {
        assertTrue(pv.isEmpty());
    }

    @Test
    public void testIsEmptyOne() {
        pv.add("Test");
        assertFalse(pv.isEmpty());
    }

    @Test
    public void testIsEmptyMultiple() {
        pv.add("Test");
        pv.add("Test1");
        pv.add("Test2");
        assertFalse(pv.isEmpty());
    }

    @Test
    public void testRemove() {
        pv.add("Test1");
        pv.add("Test2");
        pv.add("Test3");
        assertEquals(pv.remove("Test2"), "Test2");
        assertEquals(pv.size(), 2);
    }

    @Test
    public void testRemoveNotFound() {
        pv.add("Test1");
        pv.add("Test2");
        pv.add("Test3");
        assertThrows(java.util.NoSuchElementException.class, () -> pv.remove("Test"));
    }

    @Test
    public void testRemoveEmpty() {
        assertThrows(java.lang.NullPointerException.class, () -> pv.remove("Test"));
    }

    @Test
    public void testExists() {
        pv.add("Test1");
        pv.add("Test2");
        pv.add("Test3");
        assertTrue(pv.exists("Test2"));
    }

    @Test
    public void testExistsFalse() {
        pv.add("Test1");
        pv.add("Test2");
        pv.add("Test3");
        assertFalse(pv.exists("Test4"));
    }

    @Test
    public void testExistsEmpty() {
        assertFalse(pv.exists("Test"));
    }

    @Test
    public void testAsList() {
        pv.add("Test1");
        pv.add("Test5");
        pv.add("Test2");
        pv.add("Test3");
        pv.add("Test0");
        pv.add("Test8");
        pv.add("Test9");
        pv.add("Test6");
        pv.add("Test7");
        pv.add("Test4");
        var list = pv.asList();
        assertEquals(list.get(0), "Test9");
        assertEquals(list.get(1), "Test7");
        assertEquals(list.get(2), "Test8");
        assertEquals(list.get(3), "Test6");
        assertEquals(list.get(4), "Test4");
        assertEquals(list.get(5), "Test2");
        assertEquals(list.get(6), "Test5");
        assertEquals(list.get(7), "Test1");
        assertEquals(list.get(8), "Test3");
        assertEquals(list.get(9), "Test0");
    }
}