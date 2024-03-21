package timrekelj.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeznamUVTest {


    @Test
    public void testPushBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
    }

    @Test
    public void testPushMultipleWords() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushMultipleWords");
        assertEquals("OK",
                uv.processInput("push \"Test with multiple words\""));
        assertEquals("1", uv.processInput("count"));
        assertEquals("OK", uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
    }

    @Test
    public void testPushNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushNothing");
        assertEquals("Error: please specify a string",
                uv.processInput("push"));
    }

    @Test
    public void testPopBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("Test2", uv.processInput("pop"));
        assertEquals("Test1", uv.processInput("pop"));
    }
    @Test
    public void testPopMultipleWords() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopMultipleWords");
        assertEquals("OK", uv.processInput(
                "push \"Test with multiple words\""));
        assertEquals("OK", uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
        assertEquals("Another test with multiple words",
                uv.processInput("pop"));
        assertEquals("1", uv.processInput("count"));
        assertEquals("Test with multiple words",
                uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));
    }
    public void testPopNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopNothing");
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
        assertEquals("Error: please specify a string",
                uv.processInput("push"));
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
    }

    @Test
    public void testResetOnEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testResetOnEmpty");
        assertEquals("OK", uv.processInput("reset"));
    }

    @Test
    public void testResetOnFull() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testResetOnFull");
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));
    }
    @Test
    public void testCountOnEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountOnEmpty");
        assertEquals("0", uv.processInput("count"));
    }
    @Test
    public void testCountOne() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountOne");
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("1", uv.processInput("count"));
    }
    @Test
    public void testCountTwo() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountTwo");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("2", uv.processInput("count"));
    }

    @Test
    public void testIsTopEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testIsTopEmpty");
        assertEquals("Error: stack is empty", uv.processInput("isTop Test"));
    }

    @Test
    public void testIsTopTrue() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testIsTopTrue");
        uv.processInput("push Test");
        assertEquals("OK", uv.processInput("isTop Test"));
    }

    @Test
    public void testIsTopFalse() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testIsTopFalse");
        uv.processInput("push Test");
        assertEquals("Error: wrong element", uv.processInput("isTop tseT"));
    }

    @Test
    public void testIsTopNoString() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testIsTopNoString");
        assertEquals("Error: please specify a string", uv.processInput("isTop"));
    }

    @Test
    public void testSearchNoString() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testSearchNoString");
        assertEquals("Error: please specify a string", uv.processInput("search"));
    }

    @Test
    public void testSearchSuccess() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testSearchSuccess");
        uv.processInput("push Test0");
        uv.processInput("push Test1");
        uv.processInput("push Test2");
        uv.processInput("push Test3");
        assertEquals("1", uv.processInput("search Test2"));
    }

    @Test
    public void testSearchWrongString() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testSearchWrongString");
        uv.processInput("push \"Test\"");
        assertEquals("Error: invalid string", uv.processInput("search \"Test"));
    }
}
