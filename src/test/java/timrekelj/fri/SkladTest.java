package timrekelj.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {

    @Test
    void testPush() {
        Sklad<String> instance = new Sklad<>();
        String a = "Test";
        instance.push(a);
    }

    @Test
    void testPop() {
        Sklad<String> instance = new Sklad<>();
        String a = "Test";
        instance.push(a);
        String b = instance.pop();
        assertEquals(b, "Test");
    }

    @Test
    void testPopOnEmptyStact() {
        Sklad<String> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class, instance::pop);
    }

    @Test
    void popWithTwoElements() {
        Sklad<String> instance = new Sklad<>();
        String a = "TestA";
        String b = "TestB";

        instance.push(a);
        instance.push(b);

        assertEquals(instance.pop(), "TestB");
        assertEquals(instance.pop(), "TestA");
        assertThrows(java.util.NoSuchElementException.class, instance::pop);
    }

    @Test
    void isEmptyOnEmpty() {
        Sklad<String> instance = new Sklad<>();
        assertTrue(instance.isEmpty());
    }

    @Test
    void isEmptyOnFull() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test");
        assertFalse(instance.isEmpty());
    }

    @Test
    void topOnEmpty() {
        Sklad<String> instance = new Sklad<>();
        assertThrows(java.util.NoSuchElementException.class, instance::top);
    }

    @Test
    void topWithOneElement() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test");
        assertEquals(instance.top(), "Test");
    }

    @Test
    void topWithFiveElements() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        instance.push("Test4");
        instance.push("Test5");
        assertEquals(instance.top(), "Test5");
    }

    @Test
    void topTwice() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        instance.push("Test4");
        instance.push("Test5");
        assertEquals(instance.top(), "Test5");
        assertEquals(instance.top(), "Test5");
    }

    @Test
    void sizeOnEmpty() {
        Sklad<String> instance = new Sklad<>();
        assertEquals(instance.size(), 0);
    }

    @Test
    void sizeWithOneElement() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test");
        assertEquals(instance.size(), 1);
    }

    @Test
    void sizeWithFiveElements() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        instance.push("Test4");
        instance.push("Test5");
        assertEquals(instance.size(), 5);
    }

    @Test
    void searchOnTop() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(instance.search("Test3"), 0);
    }

    @Test
    void searchMiddle() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(instance.search("Test2"), 1);
    }

    @Test
    void searchBottom() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(instance.search("Test1"), 2);
    }

    @Test
    void searchNotFound() {
        Sklad<String> instance = new Sklad<>();
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(instance.search("Test"), -1);
    }

    @Test
    void searchEmpty() {
        Sklad<String> instance = new Sklad<>();
        assertEquals(instance.search("Test"), -1);
    }
}