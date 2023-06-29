package com.example.clashofclans;

import com.example.clashofclans.Hero.Barbarian;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class tempMap {


    @FXML
    private ImageView archerTower;

    @FXML
    private ImageView back;

    @FXML
    private ImageView cannon1;

    @FXML
    private ImageView cannon2;

    @FXML
    private ImageView elixirCollector1;

    @FXML
    private ImageView elixirCollector2;

    @FXML
    private ImageView maker;

    @FXML
    private ImageView map;

    @FXML
    private ImageView townHall;

    @FXML
    private AnchorPane pane;

    @FXML
    void clickedMap(MouseEvent event) {
        Barbarian barbarian = new Barbarian ();
        ImageView temp = new ImageView();
        temp.setImage(barbarian.imageView.getImage());
        temp.setFitHeight(40);
        temp.setFitWidth(40);
        temp.setX(event.getX()+151-20);
        temp.setY(event.getY()-20);
        temp.setVisible(true);
        pane.getChildren().add(temp) ;
    }

}
