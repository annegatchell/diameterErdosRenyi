package src.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Assert;
import src.main.Bag;
import java.lang.Exception;

public class BagTest {
    Bag<Integer> a;
    Bag<Character> b;
    /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        a = new Bag<Integer>();
        b = new Bag<Character>();
    }

    /**
     * Tears down the test fixture. 
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void testAdd() {
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        String expected = "4 3 2 1";
        assertEquals(expected, a.toString());
        b.add('a');
        b.add('b');
        b.add('c');
        expected = "c b a";
        assertEquals(expected, b.toString());
    }

    @Test
    public void testSize(){
        assertEquals(0, a.size());
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        assertEquals(4, a.size());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(a.isEmpty());
        a.add(1);
        assertFalse(a.isEmpty());
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("src.test.ElementTest");
    }

}