package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapElement {
    protected Vector2d position;
    private List<IPositionChangeObserver> observers=new ArrayList<>();
    public abstract String toString();
    public abstract String getImage();
    public Vector2d getPosition(){
        return this.position;
    }
    public void addObserver(IPositionChangeObserver observer){
        if(!this.observers.contains(observer)){
            this.observers.add(observer);
        }
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    protected void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : this.observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
}
