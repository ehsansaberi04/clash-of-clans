package com.example.clashofclans.Personals;

import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChooseMap implements Initializable {
//    properties
    @FXML
    private ImageView back;
    @FXML
    private ImageView OK;
    @FXML
    private ImageView frame;
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
//    clicked
    @FXML
    void clicked1(MouseEvent event) {
        choice = 1 ;
        setFrame();
    }
    @FXML
    void clicked2(MouseEvent event) {
        choice = 2 ;
        setFrame();
    }
    @FXML
    void clicked3(MouseEvent event) {
        choice = 3 ;
        setFrame();
    }
    @FXML
    void clicked4(MouseEvent event) {
        choice = 4 ;
        setFrame();
    }
    @FXML
    void clickedFrame(MouseEvent event) {

    }
    @FXML
    void clickedOK(MouseEvent event) {
        if (choice != 0) {
            try {
                player.setIndexMap(choice);
                SQLClass.players.add(player);
                SQLClass.upDateDataBase(player);
                player = null ;
                FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("login.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
                Login.setStage(stage);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {

        }
    }
//    enter
    @FXML
    void enter1(MouseEvent event) {
        map1.setScaleX(1.1);
        map1.setScaleY(1.1);
    }
    @FXML
    void enter2(MouseEvent event) {
        map2.setScaleX(1.1);
        map2.setScaleY(1.1);
    }
    @FXML
    void enter3(MouseEvent event) {
        map3.setScaleX(1.1);
        map3.setScaleY(1.1);
    }
    @FXML
    void enter4(MouseEvent event) {
        map4.setScaleX(1.1);
        map4.setScaleY(1.1);
    }
    @FXML
    void enterFrame(MouseEvent event) {
        switch (choice) {
            case 1 -> {
                map1.setScaleX(1.1);
                map1.setScaleY(1.1);
            }
            case 2 -> {
                map2.setScaleX(1.1);
                map2.setScaleY(1.1);
            }
            case 3 -> {
                map3.setScaleX(1.1);
                map3.setScaleY(1.1);
            }
            case 4 -> {
                map4.setScaleX(1.1);
                map4.setScaleY(1.1);
            }
        }
        frame.setScaleX(1.1);
        frame.setScaleY(1.1);
    }
    @FXML
    void enterOK(MouseEvent event) {
        OK.setScaleX(1.1);
        OK.setScaleY(1.1);
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
        OK.setScaleX(1);
        OK.setScaleY(1);
        frame.setScaleX(1);
        frame.setScaleY(1);
    }
//    other function
    private static int choice ;
    public int getChoice () {
        return choice ;
    }
    private Player player ;
    private void setFrame () {
        switch (choice){
            case 1->{
                frame.setVisible(true);
                frame.setX(75);
                frame.setY(25);
            }
            case 2->{
                frame.setVisible(true);
                frame.setX(575);
                frame.setY(25);
            }
            case 3->{
                frame.setVisible(true);
                frame.setX(75);
                frame.setY(325);
            }
            case 4->{
                frame.setVisible(true);
                frame.setX(575);
                frame.setY(325);
            }
        }
        frame.setScaleX(1.1);
        frame.setScaleY(1.1);
    }
//    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player = Login.getPlayer() ;
        frame.setVisible(false);
        frame.setLayoutX(0);
        frame.setLayoutY(0);
        frame.setX(0);
        frame.setY(0);
    }
//    stage
    static Stage stage ;
    public static void setStage(Stage stage) {
        ChooseMap.stage = stage;
    }
}
