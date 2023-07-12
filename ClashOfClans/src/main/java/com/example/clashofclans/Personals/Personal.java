package com.example.clashofclans.Personals;

import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Personal implements Initializable {
    @FXML
    private ImageView attack;
    @FXML
    private ImageView back;
    @FXML
    private ImageView building;
    @FXML
    private ImageView hero;
    @FXML
    private AnchorPane pane ;
    @FXML
    private ImageView profile;
//    clicked
    @FXML
    void clickedAttack(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("attack-map.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            AttackMap.setStage(stage);
            AttackMap.setPlayer(player);
        } catch (IOException e) {
            System.out.println("error : " + e.getMessage());
        }
    }
    @FXML
    void clickedBuilding(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("buildings.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            Buildings.setStage(stage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void clickedProfile(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("profile.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            Profile.setStage(stage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void clickedHero(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("heroes.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            Heroes.setStage(stage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
//    enter
    @FXML
    void enterAttack(MouseEvent event) {
        attack.setScaleX(1.1);
        attack.setScaleY(1.1);
    }
    @FXML
    void enterBack(MouseEvent event) {
        hero.setScaleX(1);
        hero.setScaleY(1);
        attack.setScaleX(1);
        attack.setScaleY(1);
        profile.setScaleX(1);
        profile.setScaleY(1);
        building.setScaleX(1);
        building.setScaleY(1);
    }
    @FXML
    void enterBuilding(MouseEvent event) {
        building.setScaleX(1.1);
        building.setScaleY(1.1);
    }
    @FXML
    void enterHero(MouseEvent event) {
        hero.setScaleX(1.1);
        hero.setScaleY(1.1);
    }
    @FXML
    void enterProfile(MouseEvent event) {
        profile.setScaleX(1.1);
        profile.setScaleY(1.1);
    }
//    other function
    private static Player player ;
    public static void setPlayer(Player player) {
        Personal.player = player;
    }
    public static Player getPlayer() {
        return player;
    }
    private void setMap() {
        String address ;
        switch (player.getIndexMap()){
            case 1 -> {
                address = Clash.class.getResource("image/image-map-1.PNG").toString() ;
            }
            case 2 -> {
                address = Clash.class.getResource("image/image-map-2.PNG").toString() ;
            }
            case 3 -> {
                address = Clash.class.getResource("image/image-map-3.PNG").toString() ;
            }
            case 4 -> {
                address = Clash.class.getResource("image/image-map-4.PNG").toString() ;
            }
            default -> {
                address = Clash.class.getResource("image/p0.png").toString() ;
            }
        }
        Image image = new Image(address);
        ImageView myMap = new ImageView();
        myMap.setImage(image);
        myMap.setFitWidth(600);
        myMap.setFitHeight(600);
        myMap.setX(150);
        myMap.setY(0);
        myMap.setVisible(true);
        pane.getChildren().add(myMap);
    }
//    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setMap();

        String address ;
        switch (player.getIndexProfile()) {
            case 1-> {
                address = Clash.class.getResource("image/p1.jpg").toString() ;
            }
            case 2-> {
                address = Clash.class.getResource("image/p2.jpg").toString() ;
            }
            case 3-> {
                address = Clash.class.getResource("image/p3.jpg").toString() ;
            }
            case 4-> {
                address = Clash.class.getResource("image/p4.jpg").toString() ;
            }
            default ->{
                address = Clash.class.getResource("image/p0.png").toString() ;
            }
        }
        profile.setImage(new Image(address));
    }
//    stage
    static Stage stage ;
    public static void setStage(Stage stage) {
        Personal.stage = stage ;
    }

}