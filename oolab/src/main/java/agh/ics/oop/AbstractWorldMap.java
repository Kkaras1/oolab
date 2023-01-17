package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    public abstract boolean canMoveTo(Vector2d position);
    public Object objectAt(Vector2d position){
        return this.animals.get(position);
    }
    public boolean isOccupied(Vector2d position){
        return this.objectAt(position) != null;
    }
    public boolean place(Animal animal){
        if(!this.canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException(animal.getPosition() + " is not legal position");
        }
        this.animals.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }
    public abstract List<Vector2d> boundaries();
    public String toString(){
        List<Vector2d> bounds=this.boundaries();
        return new MapVisualizer(this).draw(bounds.get(0),bounds.get(1));
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal=this.animals.remove(oldPosition);
        this.animals.put(newPosition,animal);
    }
}
