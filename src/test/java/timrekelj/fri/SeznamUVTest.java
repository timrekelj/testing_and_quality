package timrekelj.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeznamUVTest {

    /////////////////////////////////// SKLAD ///////////////////////////////////
    @Test
    public void s_testAddBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testAddBasic");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));
    }

    @Test
    public void s_testAddMultipleWords() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testAddMultipleWords");
        assertEquals("OK", uv.processInput("s_add \"Test with multiple words\""));
        assertEquals("1", uv.processInput("s_size"));
        assertEquals("OK", uv.processInput("s_add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("s_size"));
    }

    @Test
    public void s_testAddNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testAddNothing");
        assertEquals("Error: please specify a string", uv.processInput("s_add"));
    }

    @Test
    public void s_testRemoveFirstBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testRemoveFirstBasic");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));
        assertEquals("Test2", uv.processInput("s_remove_first"));
        assertEquals("Test1", uv.processInput("s_remove_first"));
    }
    @Test
    public void s_testRemoveFirstMultipleWords() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testRemoveFirstMultipleWords");
        assertEquals("OK", uv.processInput("s_add \"Test with multiple words\""));
        assertEquals("OK", uv.processInput("s_add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("s_size"));
        assertEquals("Another test with multiple words",uv.processInput("s_remove_first"));
        assertEquals("1", uv.processInput("s_size"));
        assertEquals("Test with multiple words", uv.processInput("s_remove_first"));
        assertEquals("0", uv.processInput("s_size"));
    }

    @Test
    public void s_testRemoveFirstNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testRemoveFirstNothing");
        assertEquals("Error: stack is empty", uv.processInput("s_remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("s_add"));
        assertEquals("Error: stack is empty", uv.processInput("s_remove_first"));
    }

    @Test
    public void s_testResetOnEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testResetOnEmpty");
        assertEquals("OK", uv.processInput("s_reset"));
    }

    @Test
    public void s_testResetOnFull() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testResetOnFull");
        assertEquals("OK", uv.processInput("s_add Test"));
        assertEquals("OK", uv.processInput("s_reset"));
        assertEquals("Error: stack is empty", uv.processInput("s_remove_first"));
        assertEquals("0", uv.processInput("s_size"));
    }
    @Test
    public void s_testSizeOnEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testSizeOnEmpty");
        assertEquals("0", uv.processInput("s_size"));
    }
    @Test
    public void s_testCountOne() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testCountOne");
        assertEquals("OK", uv.processInput("s_add Test"));
        assertEquals("1", uv.processInput("s_size"));
    }
    @Test
    public void s_testCountTwo() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testCountTwo");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));
        assertEquals("2", uv.processInput("s_size"));
    }

    @Test
    public void s_testIsFirstEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testIsFirstEmpty");
        assertEquals("Error: stack is empty", uv.processInput("s_is_first Test"));
    }

    @Test
    public void s_testIsFirstTrue() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testIsFirstTrue");
        uv.processInput("s_add Test");
        assertEquals("OK", uv.processInput("s_is_first Test"));
    }

    @Test
    public void s_testIsFirstFalse() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testIsFirstFalse");
        uv.processInput("s_add Test");
        assertEquals("Error: wrong element", uv.processInput("s_is_first tseT"));
    }

    @Test
    public void s_testIsFirstNoString() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testIsFirstNoString");
        assertEquals("Error: please specify a string", uv.processInput("s_is_first"));
    }

    @Test
    public void s_testSearchNoString() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testSearchNoString");
        assertEquals("Error: please specify a string", uv.processInput("s_search"));
    }

    @Test
    public void s_testSearchSuccess() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testSearchSuccess");
        uv.processInput("s_add Test0");
        uv.processInput("s_add Test1");
        uv.processInput("s_add Test2");
        uv.processInput("s_add Test3");
        assertEquals("1", uv.processInput("s_search Test2"));
    }

    @Test
    public void s_testSearchWrongString() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("s_testSearchWrongString");
        uv.processInput("s_add \"Test\"");
        assertEquals("Error: invalid string", uv.processInput("s_search \"Test"));
    }

    /////////////////////////////////// PRIORITETNA VRSTA ///////////////////////////////////
    @Test
    public void pq_testAddBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testAddBasic");
        assertEquals("OK", uv.processInput("pq_add Test1"));
        assertEquals("OK", uv.processInput("pq_add Test2"));
    }

    @Test
    public void pq_testAddNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testAddNothing");
        assertEquals("Error: please specify a string", uv.processInput("pq_add"));
    }

    @Test
    public void pq_testRemoveFirstBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testRemoveFirstBasic");
        assertEquals("OK", uv.processInput("pq_add Test1"));
        assertEquals("OK", uv.processInput("pq_add Test2"));
        assertEquals("Test2", uv.processInput("pq_remove_first"));
        assertEquals("Test1", uv.processInput("pq_remove_first"));
    }

    @Test
    public void pq_testRemoveFirstNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testRemoveFirstNothing");
        assertEquals("Error: priority queue is empty", uv.processInput("pq_remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("pq_add"));
        assertEquals("Error: priority queue is empty", uv.processInput("pq_remove_first"));
    }

    @Test
    public void pq_testGetFirstNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testGetFirstNothing");
        assertEquals("Error: priority queue is empty", uv.processInput("pq_get_first"));
        assertEquals("Error: please specify a string", uv.processInput("pq_add"));
        assertEquals("Error: priority queue is empty", uv.processInput("pq_get_first"));
    }

    @Test
    public void pq_testGetFirstFull() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testGetFirstFull");
        uv.processInput("pq_add Test");
        assertEquals("Test", uv.processInput("pq_get_first"));
    }

    @Test
    public void pq_testGetFirstWithRemoveFirst() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testGetFirstFull");
        uv.processInput("pq_add Test1");
        uv.processInput("pq_add Test2");
        uv.processInput("pq_remove_first");
        assertEquals("Test1", uv.processInput("pq_get_first"));
    }

    //pq_size
    @Test
    public void pq_testSizeEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testSizeEmpty");
        assertEquals("0", uv.processInput("pq_size"));
    }

    @Test
    public void pq_testSizeOne() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testSizeOne");
        uv.processInput("pq_add Test");
        assertEquals("1", uv.processInput("pq_size"));
    }

    @Test
    public void pq_testSizeTwo() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testSizeTwo");
        uv.processInput("pq_add Test1");
        uv.processInput("pq_add Test2");
        assertEquals("2", uv.processInput("pq_size"));
    }

    @Test
    public void pq_testDepthEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testDepthEmpty");
        assertEquals("0", uv.processInput("pq_depth"));
    }

    @Test
    public void pq_testDepthOne() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testDepthOne");
        uv.processInput("pq_add Test");
        assertEquals("1", uv.processInput("pq_depth"));
    }

    @Test
    public void pq_testDepthMultiple() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testDepthMultiple");
        uv.processInput("pq_add Test1");
        assertEquals("1", uv.processInput("pq_depth"));
        uv.processInput("pq_add Test2");
        assertEquals("2", uv.processInput("pq_depth"));
        uv.processInput("pq_add Test3");
        assertEquals("2", uv.processInput("pq_depth"));
        uv.processInput("pq_add Test4");
        assertEquals("3", uv.processInput("pq_depth"));
        uv.processInput("pq_add Test5");
        assertEquals("3", uv.processInput("pq_depth"));
        uv.processInput("pq_add Test6");
        assertEquals("3", uv.processInput("pq_depth"));
        uv.processInput("pq_add Test7");
        assertEquals("3", uv.processInput("pq_depth"));
        uv.processInput("pq_add Test8");
        assertEquals("4", uv.processInput("pq_depth"));
    }
    //pq_isEmpty
    @Test
    public void pq_testIsEmptyEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testIsEmptyEmpty");
        assertEquals("Priority queue is empty", uv.processInput("pq_isEmpty"));
    }

    @Test
    public void pq_testIsEmptyOne() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testIsEmptyOne");
        uv.processInput("pq_add Test");
        assertEquals("Priority queue is not empty", uv.processInput("pq_isEmpty"));
    }

    @Test
    public void pq_testIsEmptyWithRemoveFirst() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("pq_testIsEmptyOne");
        uv.processInput("pq_add Test");
        assertEquals("Priority queue is not empty", uv.processInput("pq_isEmpty"));
        uv.processInput("pq_remove_first");
        assertEquals("Priority queue is empty", uv.processInput("pq_isEmpty"));
    }
}
