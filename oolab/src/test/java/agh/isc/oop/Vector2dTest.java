package agh.isc.oop;

import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {
    @Test
    public void equalsTest(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(1,2);
        Vector2d c = new Vector2d(3,2);
        Vector2d d = new Vector2d(1,3);
        assertTrue(a.equals(a));
        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
        assertFalse(a.equals(d));
        assertFalse(d.equals(c));
    }
    @Test
    public void toStringTest(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(11,20);
        String c="(1,2)";
        String d="(11,20)";
        assertEquals(a.toString(),c);
        assertEquals(b.toString(),d);
    }
    @Test
    public void precedesTest(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(11,20);
        assertTrue(a.precedes(b));
        b = new Vector2d(1,2);
        assertTrue(a.precedes(b));
        b = new Vector2d(0,20);
        assertFalse(a.precedes(b));
        b = new Vector2d(1,0);
        assertFalse(a.precedes(b));
    }
    @Test
    public void followsTest(){
        Vector2d a = new Vector2d(11,20);
        Vector2d b = new Vector2d(1,2);
        assertTrue(a.follows(b));
        b = new Vector2d(11,20);
        assertTrue(a.follows(b));
        b = new Vector2d(20,20);
        assertFalse(a.follows(b));
        b = new Vector2d(11,30);
        assertFalse(a.follows(b));
    }
    @Test
    public void upperRightTest(){
        Vector2d a = new Vector2d(11,2);
        Vector2d b = new Vector2d(1,20);
        Vector2d c = new Vector2d(11,20);
        assertEquals(a.upperRight(b),c);
        b = new Vector2d(11,30);
        c = new Vector2d(11,30);
        assertEquals(a.upperRight(b),c);
    }
    @Test
    public void lowerLefttTest(){
        Vector2d a = new Vector2d(11,2);
        Vector2d b = new Vector2d(1,20);
        Vector2d c = new Vector2d(1,2);
        assertEquals(a.lowerLeft(b),c);
        b = new Vector2d(0,2);
        c = new Vector2d(0,2);
        assertEquals(a.lowerLeft(b),c);
    }
    @Test
    public void addTest(){
        Vector2d a = new Vector2d(11,2);
        Vector2d b = new Vector2d(1,20);
        Vector2d c = new Vector2d(12,22);
        assertEquals(a.add(b),c);
        b = new Vector2d(-1,2);
        c = new Vector2d(10,4);
        assertEquals(a.add(b),c);
    }
    @Test
    public void subtractTest(){
        Vector2d a = new Vector2d(11,2);
        Vector2d b = new Vector2d(1,20);
        Vector2d c = new Vector2d(10,-18);
        assertEquals(a.subtract(b),c);
        b = new Vector2d(-1,2);
        c = new Vector2d(12,0);
        assertEquals(a.subtract(b),c);
    }
    @Test
    public void oppositeTest(){
        Vector2d a = new Vector2d(11,2);
        Vector2d b = new Vector2d(-11,-2);
        assertEquals(a.opposite(),b);
        a = new Vector2d(-1,2);
        b = new Vector2d(1,-2);
        assertEquals(a.opposite(),b);
    }
}
