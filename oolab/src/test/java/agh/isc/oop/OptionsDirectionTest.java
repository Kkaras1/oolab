package agh.isc.oop;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class OptionsDirectionTest {
    @Test
    public void parseTest(){
        String[] args={"f","b","r","l"};
        MoveDirection[] directions={MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT};
        assertArrayEquals(new OptionsParser().parse(args),directions);
        args= new String[]{"forward", "backward", "right", "left"};
        assertArrayEquals(new OptionsParser().parse(args),directions);
        args= new String[]{"forward", "b", "r", "left"};
        assertArrayEquals(new OptionsParser().parse(args),directions);
        args= new String[]{"f", "backward", "right", "l"};
        assertArrayEquals(new OptionsParser().parse(args),directions);
        assertThrows(IllegalArgumentException.class,()->{new OptionsParser().parse(new String[]{"forward", "wwsdf", "backward", "red", "right", "fdse", "left"});});
    }
}
