package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application implements ISimulationChangeObserver {
    private AbstractWorldMap map;
    private GridPane grid;
    private Text numberMovesText;
    private int numberMoves;
    private int moveDelay;
    public void simulationChanged(){
        Platform.runLater(() -> {
            this.grid.setGridLinesVisible(false);
            this.grid.getColumnConstraints().clear();
            this.grid.getRowConstraints().clear();
            this.grid.getChildren().clear();
            this.grid.setGridLinesVisible(true);
            this.visual(this.map);
            this.numberMoves++;
            this.numberMovesText.setText("Number of moves: "+ Integer.toString(this.numberMoves));
        });
    }
    private void visual(AbstractWorldMap map){
        List<Vector2d> bounds=map.boundaries();
        Vector2d lowerLeft = bounds.get(0);
        Vector2d upperRight = bounds.get(1);
        Label label1 = new Label("y\\x");
        this.grid.add(label1, 0, 0, 1, 1);
        GridPane.setHalignment(label1, HPos.CENTER);
        for(int i=lowerLeft.x,j=1;i<=upperRight.x;i++,j++){
            Label label = new Label(Integer.toString(i));
            this.grid.add(label, j, 0, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            this.grid.getColumnConstraints().add(new ColumnConstraints(50));
        }
        this.grid.getColumnConstraints().add(new ColumnConstraints(50));
        for(int k=upperRight.y,m=1;k>=lowerLeft.y;k--,m++){
            Label label = new Label(Integer.toString(k));
            this.grid.getRowConstraints().add(new RowConstraints(50));
            this.grid.add(label, 0, m, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            for(int i=lowerLeft.x,j=1;i<=upperRight.x;i++,j++){
                AbstractMapElement element=(AbstractMapElement) map.objectAt(new Vector2d(i,k));
                if(element!=null){
                    VBox boxImage = new GuiElementBox(element).getBoxImage();
                    this.grid.add(boxImage, j, m, 1, 1);
                    GridPane.setHalignment(boxImage, HPos.CENTER);
                }
            }
        }
        this.grid.getRowConstraints().add(new RowConstraints(50));
    }
    public void start(Stage primaryStage){
        this.numberMoves=0;
        this.numberMovesText=new Text("Number of moves: "+ Integer.toString(this.numberMoves));
        this.grid = new GridPane();
        StackPane root = new StackPane();
        root.getChildren().add(this.grid);
        Button button=new Button("start");
        TextField chosenDirections=new TextField();
        HBox controlBox=new HBox(chosenDirections,button);
        VBox area=new VBox(controlBox,this.numberMovesText,root);
        this.moveDelay=500;
        //this.map=new RectangularMap(10, 5);
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        SimulationEngine engine = new SimulationEngine(this.map, positions,this.moveDelay);
        engine.addObserver(this);
        Platform.runLater(() -> {
            this.grid.setGridLinesVisible(true);
            this.visual(this.map);
        });
        button.setOnAction(actionEvent -> {
            String args1 = chosenDirections.getText();
            String[] args = args1.split(" ");
            MoveDirection[] directions = new OptionsParser().parse(args);
            engine.setDirections(directions);
            Thread thread=new Thread(engine);
            thread.start();
        });
        Scene scene = new Scene(area, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
