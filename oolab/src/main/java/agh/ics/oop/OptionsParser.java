package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] args){
        int count=0;
        for (String arg : args) {
            switch (arg) {
                case "f":
                case "forward":
                case "b":
                case "backward":
                case "r":
                case "right":
                case "l":
                case "left":
                    count++;
                    break;
            }
        }
        MoveDirection directions[]=new MoveDirection[count];
        for(int i=0,j=0;i<args.length;i++){
            switch (args[i]) {
                case "f":
                case "forward":
                    directions[j]=MoveDirection.FORWARD;
                    j++;
                    break;
                case "b":
                case "backward":
                    directions[j]=MoveDirection.BACKWARD;
                    j++;
                    break;
                case "r":
                case "right":
                    directions[j]=MoveDirection.RIGHT;
                    j++;
                    break;
                case "l":
                case "left":
                    directions[j]=MoveDirection.LEFT;
                    j++;
                    break;
                default:
                    throw new IllegalArgumentException(args[i] + " is not legal move specification");
            }
        }
        return directions;
    }
}
