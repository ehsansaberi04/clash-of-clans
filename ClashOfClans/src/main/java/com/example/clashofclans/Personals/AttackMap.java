package com.example.clashofclans.Personals;

import com.example.clashofclans.Attack.Maps.Map1;
//import com.example.clashofclans.Attack.Maps.Map2;
//import com.example.clashofclans.Attack.Maps.Map3;
//import com.example.clashofclans.Attack.Maps.Map4;
import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.* ;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AttackMap implements Initializable {
//    properties
    @FXML
    private ImageView attack;
    @FXML
    private ImageView back;
    @FXML
    private ImageView map;
    @FXML
    private ImageView next;
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView targetProfile;
    @FXML
    private ImageView exit;
    @FXML
    private Text textLimit;
    @FXML
    private Text textName;
//    clicked
    @FXML
    void clickedAttack(MouseEvent event) {
        switch (targetPlayer.getIndexMap()) {
            case 1-> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("map1.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                    stage.show();
                    Map1.setStage(stage);
                    Map1.setPlayer(player);
                    Map1.setTarget(targetPlayer);
                    Map1.setLimitHero(50);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case 2-> {
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("map2.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    stage.setScene(scene);
//                    stage.show();
//                    Map2.setStage(stage);
//                    Map2.setPlayer(player);
//                    Map2.setTarget(targetPlayer);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
            }
            case 3-> {
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("map3.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    stage.setScene(scene);
//                    stage.show();
//                    Map3.setStage(stage);
//                    Map3.setPlayer(player);
//                    Map3.setTarget(targetPlayer);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
            }
            case 4-> {
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("map4.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    stage.setScene(scene);
//                    stage.show();
//                    Map4.setStage(stage);
//                    Map4.setPlayer(player);
//                    Map4.setTarget(targetPlayer);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }
    @FXML
    void clickedNext(MouseEvent event) {
        findTarget();
    }
    @FXML
    void clickedTarget(MouseEvent event) {

    }
    @FXML
    void clickedExit(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("personal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            Personal.setStage(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        attack.setScaleX(1);
        attack.setScaleY(1);
        next.setScaleX(1);
        next.setScaleY(1);
        targetProfile.setScaleX(1);
        targetProfile.setScaleY(1);
        exit.setScaleX(1);
        exit.setScaleY(1);
    }
    @FXML
    void enterNext(MouseEvent event) {
        next.setScaleX(1.1);
        next.setScaleY(1.1);
    }
    @FXML
    void enterTarget(MouseEvent event) {
        targetProfile.setScaleX(1.1);
        targetProfile.setScaleY(1.1);
    }
    @FXML
    void enterExit(MouseEvent event) {
        exit.setScaleX(1.1);
        exit.setScaleY(1.1);
    }
    //    other function
    private static Player player ;
    private static Player targetPlayer ;

    public static void setPlayer(Player player) {
        AttackMap.player = player;
    }

    private Random random = new Random() ;
    private void findTarget () {
        do {
            int indexTarget = random.nextInt(0, SQLClass.players.size());
            targetPlayer = SQLClass.players.get(indexTarget);
        } while (targetPlayer.equals(player));
        textName.setText(targetPlayer.getName());
        textLimit.setText("limit : " + targetPlayer.getLimit());
        String address ;
        switch (targetPlayer.getIndexMap()) {
            case 1->{
                address = Clash.class.getResource("image/image-map-1.PNG").toString();
            }
            case 2->{
                address = Clash.class.getResource("image/image-map-2.PNG").toString();
            }
            case 3->{
                address = Clash.class.getResource("image/image-map-3.PNG").toString();
            }
            case 4->{
                address = Clash.class.getResource("image/image-map-4.PNG").toString();
            }
            default ->{
                address = "" ;
            }
        }
        map.setImage(new Image(address));
//        Image profile ;
//        System.out.println(targetPlayer.getIndexProfile());
//        switch (targetPlayer.getIndexProfile()) {
//            case 1->{
//                profile = new Image(Clash.class.getResource("p1.png").toString());
//            }
//            case 2->{
//                profile = new Image(Clash.class.getResource("p2.png").toString());
//            }
//            case 3->{
//                profile = new Image(Clash.class.getResource("p3.png").toString());
//            }
//            case 4->{
//                profile = new Image(Clash.class.getResource("p4.png").toString());
//            }
//            default ->{
//                profile = new Image(Clash.class.getResource("p0.png").toString());
//            }
//        }
//        targetProfile.setImage(profile);
//        textName.setText(targetPlayer.getName());
//        textLimit.setText("limit : " + targetPlayer.getLimit());
    }
//    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        findTarget();
    }
//    stage
    static Stage stage ;
    public static void setStage(Stage stage) {
        AttackMap.stage = stage;
    }
    public static void closeStage () {
        stage.close();
    }
}
