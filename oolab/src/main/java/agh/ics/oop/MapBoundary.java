package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private SortedSet<SetElement> xBounds=new TreeSet<>();
    private SortedSet<SetElement> yBounds=new TreeSet<>();
    public void addObject(AbstractMapElement element){
        element.addObserver(this);
        Vector2d position=element.getPosition();
        SetElement elementSet=new SetElement(position.x, position.y);
        this.xBounds.add(elementSet);
        elementSet=new SetElement(position.y, position.x);
        this.yBounds.add(elementSet);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        SetElement elementSet=new SetElement(oldPosition.x, oldPosition.y);
        this.xBounds.remove(elementSet);
        elementSet=new SetElement(newPosition.x, newPosition.y);
        this.xBounds.add(elementSet);
        elementSet=new SetElement(oldPosition.y, oldPosition.x);
        this.yBounds.remove(elementSet);
        elementSet=new SetElement(newPosition.y, newPosition.x);
        this.yBounds.add(elementSet);
    }
    public List<Vector2d> boundaries() {
        List<Vector2d> bounds = new ArrayList<>();
        bounds.add(new Vector2d(this.xBounds.first().getFitst(), this.yBounds.first().getFitst()));
        bounds.add(new Vector2d(this.xBounds.last().getFitst(), this.yBounds.last().getFitst()));
        return bounds;
    }
}
