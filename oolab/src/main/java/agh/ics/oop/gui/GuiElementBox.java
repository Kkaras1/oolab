package agh.ics.oop.gui;

import agh.ics.oop.AbstractMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private VBox boxImage;
    public GuiElementBox(AbstractMapElement element){
        Image image = null;
        try {
            image = new Image(new FileInputStream(element.getImage()));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label = new Label(element.toString());
        this.boxImage=new VBox(imageView,label);
        this.boxImage.setAlignment(Pos.BASELINE_CENTER);
    }
    public VBox getBoxImage() {
        return this.boxImage;
    }

}
