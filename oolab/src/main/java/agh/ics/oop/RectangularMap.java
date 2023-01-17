package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int hight;
    public RectangularMap(int weith,int hight){
        this.width=weith;
        this.hight=hight;
    }
    public boolean canMoveTo(Vector2d position){
        if(position.precedes(new Vector2d(this.width,this.hight)) && position.follows(new Vector2d(0,0)) && !this.isOccupied(position)){
            return true;
        }
        return false;
    }
    public List<Vector2d> boundaries(){
        List<Vector2d> bounds = new ArrayList<>();
        bounds.add(new Vector2d(0,0));
        bounds.add(new Vector2d(this.width,this.hight));
        return bounds;
    }
}
