package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine,Runnable {
    private IWorldMap map;
    private MoveDirection[] directions;
    private List<Animal> animals;
    private List<ISimulationChangeObserver> observers=new ArrayList<>();
    private int moveDelay;
    public SimulationEngine(MoveDirection[] directions,IWorldMap map,Vector2d[] positions,int moveDelay){
        this.map=map;
        this.moveDelay=moveDelay;
        this.directions=directions;
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map, position);
            this.map.place(animal);
            this.animals.add(animal);
        }
    }
    public SimulationEngine(IWorldMap map,Vector2d[] positions,int moveDelay){
        this.map=map;
        this.moveDelay=moveDelay;
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map, position);
            this.map.place(animal);
            this.animals.add(animal);
        }
    }
    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }
    public void run(){
        try {
            int size=this.animals.size();
            for(int i=0;i<this.directions.length;i++){
                Thread.sleep(this.moveDelay);
                Vector2d oldPosition=this.animals.get(i%size).getPosition();
                this.animals.get(i%size).move(directions[i]);
                Vector2d newPosition=this.animals.get(i%size).getPosition();
                this.positionChanged(oldPosition,newPosition);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void addObserver(ISimulationChangeObserver observer){
        if(!this.observers.contains(observer)){
            this.observers.add(observer);
        }
    }
    public void removeObserver(ISimulationChangeObserver observer){
        this.observers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(ISimulationChangeObserver observer : this.observers){
            observer.simulationChanged();
        }
    }
}
