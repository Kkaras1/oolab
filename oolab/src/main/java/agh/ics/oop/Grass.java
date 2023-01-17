package agh.ics.oop;

public class Grass extends AbstractMapElement{
    public Grass(Vector2d initialPosition){
        this.position=initialPosition;
    }
    public String toString(){
        return "T "+this.getPosition().toString();
    }
    public String getImage(){
        return "src/main/resources/grass1.png";
    }
}
