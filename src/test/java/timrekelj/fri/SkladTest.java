package timrekelj.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {

    @Test
    void testAdd() {
        Sklad<String> instance = new Sklad<>();
        String a = "Test";
        instance.add(a);
    }

    @Test
    void testRemoveFirst() {
        Sklad<String> instance = new Sklad<>();
        String a = "Test";
        instance.add(a);
        String b = instance.removeFirst();
        assertEquals(b, "Test");
    }

    @Test
    void testRemoveFirstOnEmptyStact() {
        Sklad<String> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class, instance::removeFirst);
    }

    @Test
    void removeFirstWithTwoElements() {
        Sklad<String> instance = new Sklad<>();
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
        Sklad<String> instance = new Sklad<>();
        assertTrue(instance.isEmpty());
    }

    @Test
    void isEmptyOnFull() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test");
        assertFalse(instance.isEmpty());
    }

    @Test
    void getFirstOnEmpty() {
        Sklad<String> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class, instance::getFirst);
    }

    @Test
    void getFirstWithOneElement() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test");
        assertEquals(instance.getFirst(), "Test");
    }

    @Test
    void getFirstWithFiveElements() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        instance.add("Test4");
        instance.add("Test5");
        assertEquals(instance.getFirst(), "Test5");
    }

    @Test
    void getFirstTwice() {
        Sklad<String> instance = new Sklad<>();
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
        Sklad<String> instance = new Sklad<>();
        assertEquals(instance.size(), 0);
    }

    @Test
    void sizeWithOneElement() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test");
        assertEquals(instance.size(), 1);
    }

    @Test
    void sizeWithFiveElements() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        instance.add("Test4");
        instance.add("Test5");
        assertEquals(instance.size(), 5);
    }

    @Test
    void searchOnTop() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test3"), 0);
    }

    @Test
    void searchMiddle() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test2"), 1);
    }

    @Test
    void searchBottom() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test1"), 2);
    }

    @Test
    void searchNotFound() {
        Sklad<String> instance = new Sklad<>();
        instance.add("Test1");
        instance.add("Test2");
        instance.add("Test3");
        assertEquals(instance.search("Test"), -1);
    }

    @Test
    void searchEmpty() {
        Sklad<String> instance = new Sklad<>();
        assertEquals(instance.search("Test"), -1);
    }
}