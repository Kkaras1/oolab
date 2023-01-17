package agh.isc.oop;
import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AnimalTest {
    @Test
    public void moveTest(){
        IWorldMap map=new RectangularMap(4,4);
        Animal animal1=new Animal(map);
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.getOrientation(),MapDirection.NORTH);
        assertEquals(animal1.getPosition(),new Vector2d(2,3));
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.getOrientation(),MapDirection.NORTH);
        assertEquals(animal1.getPosition(),new Vector2d(2,4));
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.getOrientation(),MapDirection.NORTH);
        assertEquals(animal1.getPosition(),new Vector2d(2,4));
        animal1.move(MoveDirection.RIGHT);
        assertEquals(animal1.getOrientation(),MapDirection.EAST);
        assertEquals(animal1.getPosition(),new Vector2d(2,4));
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.getOrientation(),MapDirection.EAST);
        assertEquals(animal1.getPosition(),new Vector2d(1,4));
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.getOrientation(),MapDirection.EAST);
        assertEquals(animal1.getPosition(),new Vector2d(0,4));
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.getOrientation(),MapDirection.EAST);
        assertEquals(animal1.getPosition(),new Vector2d(0,4));
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.getOrientation(),MapDirection.NORTH);
        assertEquals(animal1.getPosition(),new Vector2d(0,4));
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.getOrientation(),MapDirection.WEST);
        assertEquals(animal1.getPosition(),new Vector2d(0,4));
    }
    @Test
    public void moveTest1(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal1=new Animal(map,new Vector2d(2,2));
        Animal animal2=new Animal(map,new Vector2d(2,3));
        map.place(animal1);
        map.place(animal2);
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.getPosition(),new Vector2d(2,2));
    }
}
