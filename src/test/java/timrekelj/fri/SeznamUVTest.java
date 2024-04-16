package timrekelj.fri;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeznamUVTest {
    private SeznamiUV uv;
    @BeforeEach
    public void setUp() {
        uv = new SeznamiUV();
    }

    @Test
    public void testUse() {
        System.out.println("testUse");
        assertEquals("OK", uv.processInput("use sk"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("Error: please specify a data structure type (sk, pv, bst)", uv.processInput("use"));
        assertEquals("Error: please specify a correct data structure type (sk, pv, bst)", uv.processInput("use test"));
    }

    @Test
    public void testWrongCommand() {
        System.out.println("testWrongCommand");
        assertEquals("Error: Invalid command", uv.processInput("wrong command"));
    }

    /////////////////////////////////// SKLAD ///////////////////////////////////
    @Test
    public void s_testAddBasic() {
        uv.processInput("use sk");
        System.out.println("s_testAddBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
    }

    @Test
    public void s_testAddInvalidString() {
        uv.processInput("use sk");
        System.out.println("s_testAddInvalidString");
        assertEquals("Error: invalid string", uv.processInput("add \"Test"));
    }

    @Test
    public void s_testAddMultipleWords() {
        uv.processInput("use sk");
        System.out.println("s_testAddMultipleWords");
        assertEquals("OK", uv.processInput("add \"Test with multiple words\""));
        assertEquals("1", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("size"));
    }

    @Test
    public void s_testAddNothing() {
        uv.processInput("use sk");
        System.out.println("s_testAddNothing");
        assertEquals("Error: please specify a string", uv.processInput("add"));
    }

    @Test
    public void s_testRemoveFirstBasic() {
        uv.processInput("use sk");
        System.out.println("s_testRemoveFirstBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }
    @Test
    public void s_testRemoveFirstMultipleWords() {
        uv.processInput("use sk");
        System.out.println("s_testRemoveFirstMultipleWords");
        assertEquals("OK", uv.processInput("add \"Test with multiple words\""));
        assertEquals("OK", uv.processInput("add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("size"));
        assertEquals("Another test with multiple words",uv.processInput("remove_first"));
        assertEquals("1", uv.processInput("size"));
        assertEquals("Test with multiple words", uv.processInput("remove_first"));
        assertEquals("0", uv.processInput("size"));
    }

    @Test
    public void s_testRemoveFirstNothing() {
        uv.processInput("use sk");
        System.out.println("s_testRemoveFirstNothing");
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }

    @Test
    public void s_testGetFirstEmpty() {
        uv.processInput("use sk");
        System.out.println("s_testGetFirstEmpty");
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
    }

    @Test
    public void s_testGetFirstFull() {
        uv.processInput("use sk");
        System.out.println("s_testGetFirstFull");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Test3", uv.processInput("get_first"));
    }

    @Test
    public void s_testSizeEmpty() {
        uv.processInput("use sk");
        System.out.println("s_testSizeEmpty");
        assertEquals("0", uv.processInput("size"));
    }

    @Test
    public void s_testSizeOne() {
        uv.processInput("use sk");
        System.out.println("s_testSizeOne");
        uv.processInput("add Test");
        assertEquals("1", uv.processInput("size"));
    }

    @Test
    public void s_testSizeThree() {
        uv.processInput("use sk");
        System.out.println("s_testSizeThree");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("3", uv.processInput("size"));
    }

    @Test
    public void s_testIsEmptyEmpty() {
        uv.processInput("use sk");
        System.out.println("s_testIsEmptyEmpty");
        assertEquals("Data structure is empty", uv.processInput("is_empty"));
    }

    @Test
    public void s_testIsEmptyOne() {
        uv.processInput("use sk");
        System.out.println("s_testIsEmptyOne");
        uv.processInput("add Test");
        assertEquals("Data structure is not empty", uv.processInput("is_empty"));
    }

    @Test
    public void s_testIsEmptyWithRemoveFirst() {
        uv.processInput("use sk");
        System.out.println("s_testIsEmptyOne");
        uv.processInput("add Test");
        assertEquals("Data structure is not empty", uv.processInput("is_empty"));
        uv.processInput("remove_first");
        assertEquals("Data structure is empty", uv.processInput("is_empty"));
    }

    @Test
    public void s_testRemoveEmpty() {
        uv.processInput("use sk");
        System.out.println("s_testRemoveEmpty");
        assertEquals("Error: data structure is empty", uv.processInput("remove Test"));
    }

    @Test
    public void s_testRemoveNotFound() {
        uv.processInput("use sk");
        System.out.println("s_testRemoveNotFound");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Error: element not found", uv.processInput("remove Test0"));
    }

    @Test
    public void s_testRemoveNoString() {
        uv.processInput("use sk");
        System.out.println("s_testRemoveNoString");
        assertEquals("Error: please specify a string", uv.processInput("remove"));
    }

    @Test
    public void s_testRemoveSuccess() {
        uv.processInput("use sk");
        System.out.println("s_testRemoveSuccess");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Test2", uv.processInput("remove Test2"));
    }

    @Test
    public void s_testExistsEmpty() {
        uv.processInput("use sk");
        System.out.println("s_testExistsEmpty");
        assertEquals("Element does not exist", uv.processInput("exists Test"));
    }

    @Test
    public void s_testExistsNotFound() {
        uv.processInput("use sk");
        System.out.println("s_testExistsNotFound");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Element does not exist", uv.processInput("exists Test0"));
    }

    @Test
    public void s_testExistsNoString() {
        uv.processInput("use sk");
        System.out.println("s_testExistsNoString");
        assertEquals("Error: please specify a string", uv.processInput("exists"));
    }

    @Test
    public void s_testExistsSuccess() {
        uv.processInput("use sk");
        System.out.println("s_testExistsSuccess");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Element exists", uv.processInput("exists Test2"));
    }

    @Test
    public void s_testSearchNoString() {
        uv.processInput("use sk");
        System.out.println("s_testSearchNoString");
        assertEquals("Error: please specify a string", uv.processInput("search"));
    }

    @Test
    public void s_testSearchFalse() {
        uv.processInput("use sk");
        System.out.println("s_testSearchFalse");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("-1", uv.processInput("search Test0"));
    }

    @Test
    public void s_testSearchWrongDataType() {
        uv.processInput("use pv");
        System.out.println("s_testSearchWrongDataType");
        assertEquals("Error: invalid data structure type", uv.processInput("search Test"));
    }

    @Test
    public void s_testSearchSuccess() {
        uv.processInput("use sk");
        System.out.println("s_testSearchSuccess");
        uv.processInput("add Test0");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("1", uv.processInput("search Test2"));
    }

    @Test
    public void s_testResetOnEmpty() {
        uv.processInput("use sk");
        System.out.println("s_testResetOnEmpty");
        assertEquals("OK", uv.processInput("reset"));
    }

    @Test
    public void s_testResetOnFull() {
        uv.processInput("use sk");
        System.out.println("s_testResetOnFull");
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("0", uv.processInput("size"));
    }

    /////////////////////////////////// PRIORITETNA VRSTA ///////////////////////////////////
    @Test
    public void pq_testAddBasic() {
        uv.processInput("use pv");
        System.out.println("pq_testAddBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
    }

    @Test
    public void pq_testAddNothing() {
        uv.processInput("use pv");
        System.out.println("pq_testAddNothing");
        assertEquals("Error: please specify a string", uv.processInput("add"));
    }

    @Test
    public void pq_testRemoveFirstBasic() {
        uv.processInput("use pv");
        System.out.println("pq_testRemoveFirstBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }

    @Test
    public void pq_testRemoveFirstNothing() {
        uv.processInput("use pv");
        System.out.println("pq_testRemoveFirstNothing");
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }

    @Test
    public void pq_testGetFirstNothing() {
        uv.processInput("use pv");
        System.out.println("pq_testGetFirstNothing");
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
    }

    @Test
    public void pq_testGetFirstFull() {
        uv.processInput("use pv");
        System.out.println("pq_testGetFirstFull");
        uv.processInput("add Test");
        assertEquals("Test", uv.processInput("get_first"));
    }

    @Test
    public void pq_testGetFirstWithRemoveFirst() {
        uv.processInput("use pv");
        System.out.println("pq_testGetFirstFull");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("remove_first");
        assertEquals("Test1", uv.processInput("get_first"));
    }

    @Test
    public void pq_testSizeEmpty() {
        uv.processInput("use pv");
        System.out.println("pq_testSizeEmpty");
        assertEquals("0", uv.processInput("size"));
    }

    @Test
    public void pq_testSizeOne() {
        uv.processInput("use pv");
        System.out.println("pq_testSizeOne");
        uv.processInput("add Test");
        assertEquals("1", uv.processInput("size"));
    }

    @Test
    public void pq_testSizeTwo() {
        uv.processInput("use pv");
        System.out.println("pq_testSizeTwo");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        assertEquals("2", uv.processInput("size"));
    }

    @Test
    public void pq_testDepthEmpty() {
        uv.processInput("use pv");
        System.out.println("pq_testDepthEmpty");
        assertEquals("0", uv.processInput("depth"));
    }

    @Test
    public void pq_testDepthWrongDataType() {
        uv.processInput("use sk");
        System.out.println("pq_testDepthWrongDataType");
        assertEquals("Error: invalid data structure type", uv.processInput("depth"));
    }

    @Test
    public void pq_testDepthOne() {
        uv.processInput("use pv");
        System.out.println("pq_testDepthOne");
        uv.processInput("add Test");
        assertEquals("1", uv.processInput("depth"));
    }

    @Test
    public void pq_testDepthMultiple() {
        uv.processInput("use pv");
        System.out.println("pq_testDepthMultiple");
        uv.processInput("add Test1");
        assertEquals("1", uv.processInput("depth"));
        uv.processInput("add Test2");
        assertEquals("2", uv.processInput("depth"));
        uv.processInput("add Test3");
        assertEquals("2", uv.processInput("depth"));
        uv.processInput("add Test4");
        assertEquals("3", uv.processInput("depth"));
        uv.processInput("add Test5");
        assertEquals("3", uv.processInput("depth"));
        uv.processInput("add Test6");
        assertEquals("3", uv.processInput("depth"));
        uv.processInput("add Test7");
        assertEquals("3", uv.processInput("depth"));
        uv.processInput("add Test8");
        assertEquals("4", uv.processInput("depth"));
    }

    @Test
    public void pq_testIsEmptyEmpty() {
        uv.processInput("use pv");
        System.out.println("pq_testIsEmptyEmpty");
        assertEquals("Data structure is empty", uv.processInput("is_empty"));
    }

    @Test
    public void pq_testIsEmptyOne() {
        uv.processInput("use pv");
        System.out.println("pq_testIsEmptyOne");
        uv.processInput("add Test");
        assertEquals("Data structure is not empty", uv.processInput("is_empty"));
    }

    @Test
    public void pq_testIsEmptyWithRemoveFirst() {
        uv.processInput("use pv");
        System.out.println("pq_testIsEmptyOne");
        uv.processInput("add Test");
        assertEquals("Data structure is not empty", uv.processInput("is_empty"));
        uv.processInput("remove_first");
        assertEquals("Data structure is empty", uv.processInput("is_empty"));
    }

    @Test
    public void pq_testRemoveEmpty() {
        uv.processInput("use pv");
        System.out.println("pq_testRemoveEmpty");
        assertEquals("Error: data structure is empty", uv.processInput("remove Test"));
    }

    @Test
    public void pq_testRemoveNotFound() {
        uv.processInput("use pv");
        System.out.println("s_testRemoveNotFound");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Error: element not found", uv.processInput("remove Test0"));
    }

    @Test
    public void pq_testRemoveNoString() {
        uv.processInput("use pv");
        System.out.println("pq_testRemoveNoString");
        assertEquals("Error: please specify a string", uv.processInput("remove"));
    }

    @Test
    public void pq_testRemoveSuccess() {
        uv.processInput("use pv");
        System.out.println("pq_testRemoveSuccess");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Test2", uv.processInput("remove Test2"));
    }

    @Test
    public void pq_testExistsEmpty() {
        uv.processInput("use pv");
        System.out.println("pq_testExistsEmpty");
        assertEquals("Element does not exist", uv.processInput("exists Test"));
    }

    @Test
    public void pq_testExistsNotFound() {
        uv.processInput("use pv");
        System.out.println("pq_testExistsNotFound");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Element does not exist", uv.processInput("exists Test0"));
    }

    @Test
    public void pq_testExistsNoString() {
        uv.processInput("use pv");
        System.out.println("pq_testExistsNoString");
        assertEquals("Error: please specify a string", uv.processInput("exists"));
    }

    @Test
    public void pq_testExistsSuccess() {
        uv.processInput("use pv");
        System.out.println("pq_testExistsSuccess");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Element exists", uv.processInput("exists Test2"));
    }

    /////////////////////////////////// BINARNO DREVO ///////////////////////////////////
    @Test
    public void b_testAddBasic() {
        uv.processInput("use bst");
        System.out.println("b_testAddBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
    }

    @Test
    public void b_testAddNothing() {
        uv.processInput("use bst");
        System.out.println("b_testAddNothing");
        assertEquals("Error: please specify a string", uv.processInput("add"));
    }

    @Test
    public void b_testRemoveFirstBasic() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveFirstBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("Test1", uv.processInput("remove_first"));
        assertEquals("Test2", uv.processInput("remove_first"));
    }

    @Test
    public void b_testRemoveFirstNothing() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveFirstNothing");
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }

    @Test
    public void b_testGetFirstNothing() {
        uv.processInput("use bst");
        System.out.println("b_testGetFirstNothing");
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
    }

    @Test
    public void b_testGetFirstFull() {
        uv.processInput("use bst");
        System.out.println("b_testGetFirstFull");
        uv.processInput("add Test");
        assertEquals("Test", uv.processInput("get_first"));
    }

    @Test
    public void b_testGetFirstWithRemoveFirst() {
        uv.processInput("use bst");
        System.out.println("b_testGetFirstFull");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("remove_first");
        assertEquals("Test2", uv.processInput("get_first"));
    }

    @Test
    public void b_testSizeEmpty() {
        uv.processInput("use bst");
        System.out.println("b_testSizeEmpty");
        assertEquals("0", uv.processInput("size"));
    }

    @Test
    public void b_testSizeOne() {
        uv.processInput("use bst");
        System.out.println("b_testSizeOne");
        uv.processInput("add Test");
        assertEquals("1", uv.processInput("size"));
    }

    @Test
    public void b_testSizeTwo() {
        uv.processInput("use bst");
        System.out.println("b_testSizeTwo");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        assertEquals("2", uv.processInput("size"));
    }

    @Test
    public void b_testDepthEmpty() {
        uv.processInput("use bst");
        System.out.println("b_testDepthEmpty");
        assertEquals("0", uv.processInput("depth"));
    }

    @Test
    public void b_testDepthOne() {
        uv.processInput("use bst");
        System.out.println("b_testDepthOne");
        uv.processInput("add Test");
        assertEquals("1", uv.processInput("depth"));
    }

    @Test
    public void b_testDepthMultiple() {
        uv.processInput("use bst");
        System.out.println("b_testDepthMultiple");
        uv.processInput("add Test1");
        assertEquals("1", uv.processInput("depth"));
        uv.processInput("add Test5");
        assertEquals("2", uv.processInput("depth"));
        uv.processInput("add Test2");
        assertEquals("3", uv.processInput("depth"));
        uv.processInput("add Test4");
        assertEquals("4", uv.processInput("depth"));
        uv.processInput("add Test3");
        assertEquals("5", uv.processInput("depth"));
        uv.processInput("add Test6");
        assertEquals("5", uv.processInput("depth"));
        uv.processInput("add Test8");
        assertEquals("5", uv.processInput("depth"));
        uv.processInput("add Test7");
        assertEquals("5", uv.processInput("depth"));
    }

    @Test
    public void b_testIsEmptyEmpty() {
        uv.processInput("use bst");
        System.out.println("b_testIsEmptyEmpty");
        assertEquals("Data structure is empty", uv.processInput("is_empty"));
    }

    @Test
    public void b_testIsEmptyOne() {
        uv.processInput("use bst");
        System.out.println("b_testIsEmptyOne");
        uv.processInput("add Test");
        assertEquals("Data structure is not empty", uv.processInput("is_empty"));
    }

    @Test
    public void b_testIsEmptyWithRemoveFirst() {
        uv.processInput("use bst");
        System.out.println("b_testIsEmptyOne");
        uv.processInput("add Test");
        assertEquals("Data structure is not empty", uv.processInput("is_empty"));
        uv.processInput("remove_first");
        assertEquals("Data structure is empty", uv.processInput("is_empty"));
    }

    @Test
    public void b_testRemoveEmpty() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveEmpty");
        assertEquals("Error: data structure is empty", uv.processInput("remove Test"));
    }

    @Test
    public void b_testRemoveNotFound() {
        uv.processInput("use bst");
        System.out.println("s_testRemoveNotFound");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Error: element not found", uv.processInput("remove Test0"));
    }

    @Test
    public void b_testRemoveNoString() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveNoString");
        assertEquals("Error: please specify a string", uv.processInput("remove"));
    }

    @Test
    public void b_testRemoveMultipleWordsNotFound() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveMultipleWordsNotFound");
        uv.processInput("add \"1 test\"");
        assertEquals("Error: element not found", uv.processInput("remove \"2 test\""));
    }

    @Test
    public void b_testRemoveMultipleWordsInvalidString() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveMultipleWordsInvalidString");
        uv.processInput("add \"1 test\"");
        assertEquals("Error: invalid string", uv.processInput("remove \"test"));
    }

    @Test
    public void b_testRemoveMultipleWordsEmpty() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveMultipleWordsEmpty");
        assertEquals("Error: data structure is empty", uv.processInput("remove \"test test\""));
    }

    @Test
    public void b_testRemoveMultipleWords() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveMultipleWords");
        uv.processInput("add \"1 test test\"");
        uv.processInput("add \"2 test test\"");
        uv.processInput("add \"3 test test\"");
        uv.processInput("add \"4 test test\"");
        assertEquals("1 test test", uv.processInput("remove \"1 test test\""));
    }

    @Test
    public void b_testRemoveSuccess() {
        uv.processInput("use bst");
        System.out.println("b_testRemoveSuccess");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Test2", uv.processInput("remove Test2"));
    }

    @Test
    public void b_testExistsEmpty() {
        uv.processInput("use bst");
        System.out.println("b_testExistsEmpty");
        assertEquals("Element does not exist", uv.processInput("exists Test"));
    }

    @Test
    public void b_testExistsNotFound() {
        uv.processInput("use bst");
        System.out.println("b_testExistsNotFound");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Element does not exist", uv.processInput("exists Test0"));
    }

    @Test
    public void b_testExistsNoString() {
        uv.processInput("use bst");
        System.out.println("b_testExistsNoString");
        assertEquals("Error: please specify a string", uv.processInput("exists"));
    }

    @Test
    public void b_testExistsSuccess() {
        uv.processInput("use bst");
        System.out.println("b_testExistsSuccess");
        uv.processInput("add Test1");
        uv.processInput("add Test2");
        uv.processInput("add Test3");
        assertEquals("Element exists", uv.processInput("exists Test2"));
    }
}
