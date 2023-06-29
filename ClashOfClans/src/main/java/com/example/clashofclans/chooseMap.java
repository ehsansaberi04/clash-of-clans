package com.example.clashofclans;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class chooseMap {

    @FXML
    private ImageView map1;

    @FXML
    private ImageView map2;

    @FXML
    private ImageView map3;

    @FXML
    private ImageView map4;
    private int choice ;

    @FXML
    void clicked1(MouseEvent event) {
        choice = 1 ;
    }

    @FXML
    void clicked2(MouseEvent event) {
        choice = 2 ;
    }

    @FXML
    void clicked3(MouseEvent event) {
        choice = 3 ;
    }

    @FXML
    void clicked4(MouseEvent event) {
        choice = 4 ;
    }

    private void sendingChoice () {
//        Login.setIndexMap(choice);
//        Parent parent = null;
//        try {
//            parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-map.fxml")));
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
//            Scene scene = new Scene(parent) ;
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
