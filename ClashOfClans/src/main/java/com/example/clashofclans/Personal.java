package com.example.clashofclans;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Personal implements Initializable {
    @FXML
    private ImageView attack;
    @FXML
    private ImageView back;
    @FXML
    private ImageView hero;
    @FXML
    private AnchorPane pane ;
    @FXML
    private ImageView profile;

    @FXML
    void clickedAttack(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attack-map.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("error : " + e.getMessage());
        }
    }

    @FXML
    void clickedProfile(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void clickedHero(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("heroes.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }




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
        pane.getChildren().add(myMap) ;
    }

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


}