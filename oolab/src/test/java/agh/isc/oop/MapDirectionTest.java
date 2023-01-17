package agh.isc.oop;

import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MapDirectionTest {
    @Test
    public void nextTest(){
        MapDirection a=MapDirection.NORTH;
        MapDirection b=MapDirection.EAST;
        assertEquals(a.next(), b);
        a=MapDirection.EAST;
        b=MapDirection.SOUTH;
        assertEquals(a.next(), b);
        a=MapDirection.SOUTH;
        b=MapDirection.WEST;
        assertEquals(a.next(), b);
        a=MapDirection.WEST;
        b=MapDirection.NORTH;
        assertEquals(a.next(), b);
    }
    @Test
    public void previousTest(){
        MapDirection a=MapDirection.NORTH;
        MapDirection b=MapDirection.WEST;
        assertEquals(a.previous(), b);
        a=MapDirection.WEST;
        b=MapDirection.SOUTH;
        assertEquals(a.previous(), b);
        a=MapDirection.SOUTH;
        b=MapDirection.EAST;
        assertEquals(a.previous(), b);
        a=MapDirection.EAST;
        b=MapDirection.NORTH;
        assertEquals(a.previous(), b);
    }

}
