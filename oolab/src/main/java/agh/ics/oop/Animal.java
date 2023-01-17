package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractMapElement{
    private MapDirection orientation;
    private IWorldMap map;
    public Animal(IWorldMap map){
        this.position=new Vector2d(2,2);
        this.orientation=MapDirection.NORTH;
        this.map=map;
    }
    public Animal(IWorldMap map,Vector2d initialPosition){
        this.position=initialPosition;
        this.orientation=MapDirection.NORTH;
        this.map=map;
    }
    public String toString(){
        return "Z "+this.getPosition().toString();
    }
    public String getImage(){
        return switch (this.orientation) {
            case EAST -> "src/main/resources/right.png";
            case WEST -> "src/main/resources/left.png";
            case SOUTH -> "src/main/resources/down.png";
            case NORTH -> "src/main/resources/up.png";
        };
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public MapDirection getOrientation(){
        return this.orientation;
    }
    public void move(MoveDirection direction){
        Vector2d oldPosition=this.position;
        switch(direction){
            case RIGHT:
                this.orientation=this.orientation.next();
                break;
            case LEFT:
                this.orientation=this.orientation.previous();
                break;
            case FORWARD:
                Vector2d newPosition1=this.position.add(this.orientation.toUnitVector());
                if(this.map.canMoveTo(newPosition1)){
                    this.position=newPosition1;
                    this.positionChanged(oldPosition,newPosition1);
                }
                break;
            case BACKWARD:
                Vector2d newPosition2=this.position.subtract(this.orientation.toUnitVector());
                if(this.map.canMoveTo(newPosition2)){
                    this.position=newPosition2;
                    this.positionChanged(oldPosition,newPosition2);
                }
                break;
        }
    }
}
