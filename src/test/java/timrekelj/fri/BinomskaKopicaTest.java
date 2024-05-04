package timrekelj.fri;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinomskaKopicaTest {
    private BinomskaKopica<String> bk;

    public BinomskaKopicaTest() {}

    @BeforeEach
    public void setUp() {
        bk = new BinomskaKopica<>();
    }

    @Test
    public void testAdd() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        bk.add("Test6");
        assertEquals(bk.getFirst(), "Test9");
    }

    @Test
    public void testGetFirst() {
        assertThrows(java.util.NoSuchElementException.class, () -> bk.getFirst());
        bk.add("Test1");
        assertEquals(bk.getFirst(), "Test1");
        bk.add("Test5");
        assertEquals(bk.getFirst(), "Test5");
        bk.add("Test2");
        assertEquals(bk.getFirst(), "Test5");
        bk.add("Test3");
        assertEquals(bk.getFirst(), "Test5");
        bk.add("Test0");
        assertEquals(bk.getFirst(), "Test5");
        bk.add("Test8");
        assertEquals(bk.getFirst(), "Test8");
        bk.add("Test9");
        assertEquals(bk.getFirst(), "Test9");
        bk.add("Test6");
        assertEquals(bk.getFirst(), "Test9");
    }

    @Test
    public void testRemoveFirst() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        bk.add("Test6");
        assertEquals(bk.removeFirst(), "Test9");
        assertEquals(bk.removeFirst(), "Test8");
        assertEquals(bk.removeFirst(), "Test6");
        assertEquals(bk.removeFirst(), "Test5");
        assertEquals(bk.removeFirst(), "Test3");
        assertEquals(bk.removeFirst(), "Test2");
        assertEquals(bk.removeFirst(), "Test1");
        assertEquals(bk.removeFirst(), "Test0");
        assertThrows(java.util.NoSuchElementException.class, () -> bk.removeFirst());
    }

    @Test
    public void testRemoveEmpty() {
        assertThrows(java.lang.NullPointerException.class, () -> bk.remove("Test"));
    }

    @Test
    public void testRemove() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        bk.add("Test6");
        assertThrows(java.util.NoSuchElementException.class, () -> bk.remove("Test"));
        assertEquals(bk.remove("Test0"), "Test0");
        assertEquals(bk.remove("Test5"), "Test5");
        assertEquals(bk.remove("Test1"), "Test1");
        assertEquals(bk.remove("Test8"), "Test8");
        assertEquals(bk.remove("Test6"), "Test6");
        assertEquals(bk.remove("Test2"), "Test2");
        assertEquals(bk.remove("Test9"), "Test9");
        assertEquals(bk.remove("Test3"), "Test3");
    }

    @Test
    public void testAnotherRemove() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        bk.add("Test6");
        assertThrows(java.util.NoSuchElementException.class, () -> bk.remove("Test"));
        assertEquals(bk.remove("Test0"), "Test0");
        assertEquals(bk.remove("Test8"), "Test8");
    }

    @Test
    public void testSize() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        bk.add("Test6");
        assertEquals(bk.size(), 8);
    }

    @Test
    public void testDepth() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        assertEquals(bk.depth(), 3);
    }

    @Test
    public void testIsEmpty() {
        assertEquals(bk.isEmpty(), true);
        bk.add("Test1");
        assertEquals(bk.isEmpty(), false);
    }

    @Test
    public void testExists() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        assertEquals(bk.exists("Test1"), true);
        assertEquals(bk.exists("Test5"), true);
        assertEquals(bk.exists("Test2"), true);
        assertEquals(bk.exists("Test3"), true);
        assertEquals(bk.exists("Test0"), true);
        assertEquals(bk.exists("Test8"), true);
        assertEquals(bk.exists("Test9"), true);
        assertEquals(bk.exists("Test7"), false);
    }

    @Test
    public void testAsList() {
        bk.add("Test1");
        bk.add("Test5");
        bk.add("Test2");
        bk.add("Test3");
        bk.add("Test0");
        bk.add("Test8");
        bk.add("Test9");
        bk.add("Test6");
        List<String> list = bk.asList();
        assertEquals(list.get(0), "Test9");
        assertEquals(list.get(1), "Test5");
        assertEquals(list.get(2), "Test3");
        assertEquals(list.get(3), "Test2");
        assertEquals(list.get(4), "Test1");
        assertEquals(list.get(5), "Test8");
        assertEquals(list.get(6), "Test0");
        assertEquals(list.get(7), "Test6");
    }

    @Test
    public void testAsListEmpty() {
        List<String> list = bk.asList();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testAsListOne() {
        bk.add("Test1");
        List<String> list = bk.asList();
        assertEquals(list.size(), 1);
    }
}
