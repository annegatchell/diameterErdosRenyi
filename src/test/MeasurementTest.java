package src.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Assert;
import java.lang.Exception;

import src.main.Measurement;

public class MeasurementTest {
    Measurement data;
    Measurement avg;
    /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        data = new Measurement();
        avg = new Measurement();
    }

    /**
     * Tears down the test fixture. 
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void testAverage() {
        data.addData(1,0,0,0);
        data.addData(1,1,1,1);
        data.addData(1,2,2,2);
        data.addData(1,3,3,3);
        data.addData(1,4,4,4);
        data.addData(1,5,5,5);
        data.addData(1,6,6,6);
        data.addData(1,7,7,7);
        data.addData(1,8,8,8);
        data.addData(1,9,9,9);
        StringBuilder s = new StringBuilder();
        s.append("\\addplot coordinates {\n");
        s.append("(1, 9)\n");
        s.append("(1, 8)\n");
        s.append("(1, 7)\n");
        s.append("(1, 6)\n");
        s.append("(1, 5)\n");
        s.append("(1, 4)\n");
        s.append("(1, 3)\n");
        s.append("(1, 2)\n");
        s.append("(1, 1)\n");
        s.append("(1, 0)\n");
        s.append("};");
        String expected = s.toString();
        assertEquals(expected, data.diameterDataString());
        data.averageAllAddToMeasurement(avg);
        s = new StringBuilder();
        s.append("\\addplot coordinates {\n");
        s.append("(1, 4)\n");
        s.append("};");
        expected = s.toString();
        assertEquals(expected, avg.diameterDataString());
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("src.test.ElementTest");
    }

}