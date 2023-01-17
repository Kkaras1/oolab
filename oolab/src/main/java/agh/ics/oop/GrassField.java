package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private int numberGrasses;
    private Map<Vector2d,Grass> grasses = new HashMap<>();
    private MapBoundary boundary;
    public GrassField(int numberGrasses){
        this.boundary=new MapBoundary();
        this.numberGrasses=numberGrasses;
        for(int i=0;i<this.numberGrasses;i++){
            Grass grass=this.createGrass();
            this.grasses.put(grass.getPosition(),grass);
            this.boundary.addObject(grass);
        }
    }
    private Grass createGrass(){
        while(true) {
            Vector2d position1 = new Vector2d((int) (Math.random() * Math.sqrt(this.numberGrasses * 10)), (int) (Math.random() * Math.sqrt(this.numberGrasses * 10)));
            if (!this.isOccupied(position1)) {
                Grass grass=new Grass(position1);
                return grass;
            }
        }
    }
    private Grass createGrass(Grass grass){
        while(true) {
            Vector2d position1 = new Vector2d((int) (Math.random() * Math.sqrt(this.numberGrasses * 10)), (int) (Math.random() * Math.sqrt(this.numberGrasses * 10)));
            if (!this.isOccupied(position1)) {
                grass.position=position1;

                return grass;
            }
        }
    }
    public Object objectAt(Vector2d position){
        Object object=super.objectAt(position);
        if(object!=null){
            return object;
        }
        return this.grasses.get(position);
    }
    public boolean canMoveTo(Vector2d position){
        Object object= this.objectAt(position);
        if(object==null){
            return true;
        }
        if(object instanceof Grass){
            return true;
        }
        return false;
    }
    public boolean place(Animal animal){
        boolean status=super.place(animal);
        this.boundary.addObject(animal);
        return status;
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Object object= this.objectAt(newPosition);
        if(object instanceof Grass){
            Grass grass=(Grass)object;
            this.createGrass(grass);
            this.grasses.remove(newPosition,grass);
            this.grasses.put(grass.getPosition(),grass);
            grass.positionChanged(newPosition,grass.getPosition());
        }
        super.positionChanged(oldPosition,newPosition);
    }
    public List<Vector2d> boundaries(){
        return this.boundary.boundaries();
    }
}
