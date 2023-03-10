package agh.isc.oop;

import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    @Test
    public void runTest1(){
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions,0);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3,5)));
        assertTrue(map.isOccupied(new Vector2d(2,0)));
    }
    @Test
    public void runTest2(){
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions,0);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3,7)));
        assertTrue(map.isOccupied(new Vector2d(2,-1)));
    }
}
