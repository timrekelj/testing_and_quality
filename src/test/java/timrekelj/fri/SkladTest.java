package timrekelj.fri;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {

    private Sklad<String> instance;

    @BeforeEach
    public void setUp() {
        instance = new Sklad<>();
    }

    @Test
    void testAdd() {
        String a = "Test";
        instance.add(a);
    }

    @Test
    void testRemoveFirst() {
        String a = "Test";
        instance.add(a);
        String b = instance.removeFirst();
        assertEquals(b, "Test");
    }

    @Test
    void testRemoveFirstOnEmptyStact() {
        assertThrows(java.util.NoSuchElementException.class, instance::removeFirst);
    }

    @Test
    void removeFirstWithTwoElements() {
        String a = "TestA";
        String b = "TestB";

        instance.add(a);
        instance.add(b);

        assertEquals(instance.removeFirst(), "TestB");
        assertEquals(instance.removeFirst(), "TestA");
        assertThrows(java.util.NoSuchElementException.class, instance::removeFirst);
    }

    @Test
    void isEmptyOnEmpty() {
        assertTrue(instance.isEmpty());
    }

    @Test
    void isEmptyOnFull() {
        instance.add("Test");
        assertFalse(instance.isEmpty());
    }

    @Test
    void getFirstOnEmpty() {
        assertThrows(java.util.NoSuchElementException.class, instance::getFirst);
    }

    @Test
    void getFirstWithOneElement() {
        instance.add("Test");
        assertEquals(instance.getFirst(), "Test");
    }

    @Test
    void getFirstWithFiveElements() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        instance.add("Test4");
        instance.add("Test5");
        assertEquals(instance.getFirst(), "Test5");
    }

    @Test
    void getFirstTwice() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        instance.add("Test4");
        instance.add("Test5");
        assertEquals(instance.getFirst(), "Test5");
        assertEquals(instance.getFirst(), "Test5");
    }

    @Test
    void sizeOnEmpty() {
        assertEquals(instance.size(), 0);
    }

    @Test
    void sizeWithOneElement() {
        instance.add("Test");
        assertEquals(instance.size(), 1);
    }

    @Test
    void sizeWithFiveElements() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        instance.add("Test4");
        instance.add("Test5");
        assertEquals(instance.size(), 5);
    }

    @Test
    void searchOnTop() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test3"), 0);
    }

    @Test
    void searchMiddle() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test2"), 1);
    }

    @Test
    void searchBottom() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test1"), 2);
    }

    @Test
    void searchNotFound() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test"), -1);
    }

    @Test
    void searchEmpty() {
        assertEquals(instance.search("Test"), -1);
    }

    @Test
    void remove() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.remove("Test2"), "Test2");
        assertEquals(instance.size(), 2);
        assertEquals(instance.getFirst(), "Test3");
        assertEquals(instance.removeFirst(), "Test3");
        assertEquals(instance.removeFirst(), "Test1");
    }

    @Test
    void removeNotFound() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertThrows(java.util.NoSuchElementException.class, () -> instance.remove("Test"));
    }

    @Test
    void removeEmpty() {
        assertThrows(java.util.NoSuchElementException.class, () -> instance.remove("Test"));
    }

    @Test
    void exists() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertTrue(instance.exists("Test2"));
    }

    @Test
    void existsFalse() {
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertFalse(instance.exists("Test4"));
    }

    @Test
    void existsEmpty() {
        assertFalse(instance.exists("Test"));
    }
}