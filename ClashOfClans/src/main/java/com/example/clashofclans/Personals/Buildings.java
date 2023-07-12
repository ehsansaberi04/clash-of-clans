package com.example.clashofclans.Personals;

import com.example.clashofclans.Model.Building.*;
import com.example.clashofclans.Clash;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.* ;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Buildings implements Initializable {
//    properties
    @FXML
    private ImageView archerTower;
    @FXML
    private ImageView back;
    @FXML
    private ImageView backPane1;
    @FXML
    private ImageView cannon;
    @FXML
    private ImageView elixir;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView maker;
    @FXML
    private AnchorPane pane;
    @FXML
    private Pane pane1;
    @FXML
    private Text textBord;
    @FXML
    private Text textDamage;
    @FXML
    private Text textHealth;
    @FXML
    private Text textLevel;
    @FXML
    private Text textName;
    @FXML
    private Text textSpeedAttack;
    @FXML
    private Text textType;
    @FXML
    private ImageView townHall;
//    clicked
    @FXML
    void clickedArcherTower(MouseEvent event) {
        pane1.setVisible(true);
        ArcherTower archer1 = new ArcherTower(archerTower) ;
        textLevel.setText("lvl : " + archer1.getLevel());
        textName.setText("Archer Tower");
        textType.setText("Type : " + archer1.getType());
        textHealth.setText("Health : " + archer1.getHealth());
        textDamage.setText("Damage : " + archer1.getDamage());
        textSpeedAttack.setText("Attack Speed : " + archer1.getSpeedDamage());
        textBord.setText("Bord : " + archer1.getBord());
        backPane1.setImage(new Image(Clash.class.getResource("image/green.png").toString()));
        backPane1.setOpacity(0.9);
    }
    @FXML
    void clickedCannon(MouseEvent event) {
        pane1.setVisible(true);
        Cannon cannon1 = new Cannon(cannon) ;
        textLevel.setText("lvl : " + cannon1.getLevel());
        textName.setText("Cannon");
        textType.setText("Type : " + cannon1.getType());
        textHealth.setText("Health : " + cannon1.getHealth());
        textDamage.setText("Damage : " + cannon1.getDamage());
        textSpeedAttack.setText("Attack Speed : " + cannon1.getSpeedDamage());
        textBord.setText("Bord : " + cannon1.getBord());
        backPane1.setImage(new Image(Clash.class.getResource("image/back-cannon.jpg").toString()));
        backPane1.setOpacity(0.9);
    }
    @FXML
    void clickedElixir(MouseEvent event) {
        pane1.setVisible(true);
        ElixirMaker elixir1 = new ElixirMaker(elixir) ;
        textLevel.setText("lvl : " + elixir1.getLevel());
        textName.setText("Elixir Collector");
        textType.setText("Type : " + elixir1.getType());
        textHealth.setText("Health : " + elixir1.getHealth());
        textDamage.setText("");
        textSpeedAttack.setText("");
        textBord.setText("");
        backPane1.setImage(new Image(Clash.class.getResource("image/back-elixir.jpg").toString()));
        backPane1.setOpacity(0.9);
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
    @FXML
    void clickedMaker(MouseEvent event) {
        pane1.setVisible(true);
        Maker maker1 = new Maker(maker) ;
        textLevel.setText("lvl : " + maker1.getLevel());
        textName.setText("Barrack");
        textType.setText("Type : " + maker1.getType());
        textHealth.setText("Health : " + maker1.getHealth());
        textDamage.setText("");
        textSpeedAttack.setText("");
        textBord.setText("");
        backPane1.setImage(new Image(Clash.class.getResource("image/back-maker.jpg").toString()));
        backPane1.setOpacity(0.9);
    }
    @FXML
    void clickedTownHall(MouseEvent event) {
        pane1.setVisible(true);
        TownHall townHall1 = new TownHall(townHall) ;
        textLevel.setText("lvl : " + townHall1.getLevel());
        textName.setText("Town hall");
        textType.setText("Type : " + townHall1.getType());
        textHealth.setText("Health : " + townHall1.getHealth());
        textDamage.setText("");
        textSpeedAttack.setText("");
        textBord.setText("");
        backPane1.setImage(new Image(Clash.class.getResource("image/back-town-hall.jpg").toString()));
        backPane1.setOpacity(0.9);
    }
//    enter
    @FXML
    void enterArcherTower(MouseEvent event) {
        archerTower.setScaleX(1.1);
        archerTower.setScaleY(1.1);
        cannon.setScaleX(1);
        cannon.setScaleY(1);
        elixir.setScaleX(1);
        elixir.setScaleY(1);
        townHall.setScaleX(1);
        townHall.setScaleY(1);
        maker.setScaleX(1);
        maker.setScaleY(1);
    }
    @FXML
    void enterBack(MouseEvent event) {
        archerTower.setScaleX(1);
        archerTower.setScaleY(1);
        cannon.setScaleX(1);
        cannon.setScaleY(1);
        elixir.setScaleX(1);
        elixir.setScaleY(1);
        townHall.setScaleX(1);
        townHall.setScaleY(1);
        maker.setScaleX(1);
        maker.setScaleY(1);
        exit.setScaleX(1);
        exit.setScaleY(1);
    }
    @FXML
    void enterCannon(MouseEvent event) {
        cannon.setScaleX(1.1);
        cannon.setScaleY(1.1);
        archerTower.setScaleX(1);
        archerTower.setScaleY(1);
        elixir.setScaleX(1);
        elixir.setScaleY(1);
        townHall.setScaleX(1);
        townHall.setScaleY(1);
        maker.setScaleX(1);
        maker.setScaleY(1);
    }
    @FXML
    void enterElixir(MouseEvent event) {
        elixir.setScaleX(1.1);
        elixir.setScaleY(1.1);
        archerTower.setScaleX(1);
        archerTower.setScaleY(1);
        cannon.setScaleX(1);
        cannon.setScaleY(1);
        townHall.setScaleX(1);
        townHall.setScaleY(1);
        maker.setScaleX(1);
        maker.setScaleY(1);
    }
    @FXML
    void enterExit(MouseEvent event) {
        exit.setScaleX(1.1);
        exit.setScaleY(1.1);
    }
    @FXML
    void enterMaker(MouseEvent event) {
        maker.setScaleX(1.1);
        maker.setScaleY(1.1);
        archerTower.setScaleX(1);
        archerTower.setScaleY(1);
        cannon.setScaleX(1);
        cannon.setScaleY(1);
        elixir.setScaleX(1);
        elixir.setScaleY(1);
        townHall.setScaleX(1);
        townHall.setScaleY(1);
    }
    @FXML
    void enterTownHall(MouseEvent event) {
        townHall.setScaleX(1.1);
        townHall.setScaleY(1.1);
        archerTower.setScaleX(1);
        archerTower.setScaleY(1);
        cannon.setScaleX(1);
        cannon.setScaleY(1);
        elixir.setScaleX(1);
        elixir.setScaleY(1);
        maker.setScaleX(1);
        maker.setScaleY(1);
    }
//    other function

//    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pane1.setVisible(false);
    }
//    stage
    static Stage stage ;
    public static void setStage(Stage stage) {
        Buildings.stage = stage;
    }
    public static void closeStage () {
        stage.close();
    }
}
