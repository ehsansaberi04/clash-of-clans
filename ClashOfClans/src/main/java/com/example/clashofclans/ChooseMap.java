package com.example.clashofclans;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChooseMap implements Initializable {

    @FXML
    private ImageView back;

    @FXML
    private Button OKButton;

    @FXML
    private ImageView map1;

    @FXML
    private ImageView map2;

    @FXML
    private ImageView map3;

    @FXML
    private ImageView map4;
    @FXML
    private AnchorPane pane;


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
    @FXML
    void clickedOK(MouseEvent event) {
        if (choice != 0) {
            try {
                player.setIndexMap(choice);
                SQLClass.players.add(player);
                player = null ;
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {

        }
    }

    @FXML
    void enter1(MouseEvent event) {
        map1.setScaleX(0.9);
        map1.setScaleY(0.9);
    }

    @FXML
    void enter2(MouseEvent event) {
        map2.setScaleX(0.9);
        map2.setScaleY(0.9);
    }

    @FXML
    void enter3(MouseEvent event) {
        map3.setScaleX(0.9);
        map3.setScaleY(0.9);
    }

    @FXML
    void enter4(MouseEvent event) {
        map4.setScaleX(0.9);
        map4.setScaleY(0.9);
    }
    @FXML
    void enterBack(MouseEvent event) {
        map1.setScaleX(1);
        map1.setScaleY(1);
        map2.setScaleX(1);
        map2.setScaleY(1);
        map3.setScaleX(1);
        map3.setScaleY(1);
        map4.setScaleX(1);
        map4.setScaleY(1);
        switch (choice){
            case 1->{
                map1.setScaleX(1.1);
                map1.setScaleY(1.1);
            }
            case 2->{
                map2.setScaleX(1.1);
                map2.setScaleY(1.1);
            }
            case 3->{
                map3.setScaleX(1.1);
                map3.setScaleY(1.1);
            }
            case 4->{
                map4.setScaleX(1.1);
                map4.setScaleY(1.1);
            }
        }
    }

    private static int choice ;
    public int getChoice () {
        return choice ;
    }

    private Player player ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player = Login.getPlayer() ;
    }
}
