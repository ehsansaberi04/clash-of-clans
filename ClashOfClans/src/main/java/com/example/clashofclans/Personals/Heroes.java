package com.example.clashofclans.Personals;

import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Hero.* ;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Heroes implements Initializable {
//    properties
    @FXML
    private ImageView archer;
    @FXML
    private ImageView back;
    @FXML
    private ImageView backPane1;
    @FXML
    private ImageView barbar;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView giant;
    @FXML
    private AnchorPane pane;
    @FXML
    private Pane pane1;
    @FXML
    private ImageView pekka;
    @FXML
    private Text textAttackType;
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
    private Text textSpace ;
    @FXML
    private Text textSpeed;
    @FXML
    private Text textSpeedAttack;
//    clicked
    @FXML
    void clickedArcher(MouseEvent event) {
        pane1.setVisible(true);
        Archer archer1 = new Archer(Archer.imageView) ;
        textLevel.setText("lvl : " + Archer.getLevel());
        textName.setText("Archer");
        textHealth.setText("Health : " + archer1.getHealth());
        textDamage.setText("Damage : " + archer1.getDamage());
        textSpeedAttack.setText("Attack Speed : " + archer1.getSpeedDamage());
        textAttackType.setText("Target type : " + archer1.getTarget());
        textSpeed.setText("Speed : " + archer1.getSpeed());
        textBord.setText("Bord : " + archer1.getSpeed());
        textSpace.setText("Space : " + archer1.getSpace());
        backPane1.setImage(new Image(Clash.class.getResource("image/back-archer.jpg").toString()));
        backPane1.setOpacity(0.9);
    }
    @FXML
    void clickedBarbar(MouseEvent event) {
        pane1.setVisible(true);
        Barbarian barbarian1 = new Barbarian(Barbarian.imageView) ;
        textLevel.setText("lvl : " + Barbarian.getLevel());
        textName.setText("barbarian");
        textHealth.setText("Health : " + barbarian1.getHealth());
        textDamage.setText("Damage : " + barbarian1.getDamage());
        textSpeedAttack.setText("Attack Speed : " + barbarian1.getSpeedDamage());
        textAttackType.setText("Target type : " + barbarian1.getTarget());
        textSpeed.setText("Speed : " + barbarian1.getSpeed());
        textBord.setText("Bord : " + barbarian1.getSpeed());
        textSpace.setText("Space : " + barbarian1.getSpace());
        backPane1.setImage(new Image(Clash.class.getResource("image/back-barbar.jpg").toString()));
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
    void clickedGiant(MouseEvent event) {
        pane1.setVisible(true);
        Giant giant1 = new Giant(Giant.imageView) ;
        textLevel.setText("lvl : " + Giant.getLevel());
        textName.setText("giant");
        textHealth.setText("Health : " + giant1.getHealth());
        textDamage.setText("Damage : " + giant1.getDamage());
        textSpeedAttack.setText("Attack Speed : " + giant1.getSpeedDamage());
        textAttackType.setText("Target type : " + giant1.getTarget());
        textSpeed.setText("Speed : " + giant1.getSpeed());
        textBord.setText("Bord : " + giant1.getSpeed());
        textSpace.setText("Space : " + giant1.getSpace());
        backPane1.setImage(new Image(Clash.class.getResource("image/back-giant.jpg").toString()));
        backPane1.setOpacity(0.9);
    }
    @FXML
    void clickedPekka(MouseEvent event) {
        pane1.setVisible(true);
        Pekka pekka1 = new Pekka(Pekka.imageView) ;
        textLevel.setText("lvl : " + Pekka.getLevel());
        textName.setText("pekka");
        textHealth.setText("Health : " + pekka1.getHealth());
        textDamage.setText("Damage : " + pekka1.getDamage());
        textSpeedAttack.setText("Attack Speed : " + pekka1.getSpeedDamage());
        textAttackType.setText("Target type : " + pekka1.getTarget());
        textSpeed.setText("Speed : " + pekka1.getSpeed());
        textBord.setText("Bord : " + pekka1.getSpeed());
        textSpace.setText("Space : " + pekka1.getSpace());
        backPane1.setImage(new Image(Clash.class.getResource("image/back-pekka.jpg").toString()));
        backPane1.setOpacity(0.9);
    }
//    enter
    @FXML
    void enterPekka(MouseEvent event) {
        pekka.setScaleX(1.1);
        pekka.setScaleY(1.1);
    }
    @FXML
    void enterArcher(MouseEvent event) {
        archer.setScaleX(1.1);
        archer.setScaleY(1.1);
    }
    @FXML
    void enterBack(MouseEvent event) {
        pekka.setScaleX(1);
        pekka.setScaleY(1);
        archer.setScaleX(1);
        archer.setScaleY(1);
        barbar.setScaleX(1);
        barbar.setScaleY(1);
        giant.setScaleX(1);
        giant.setScaleY(1);
        exit.setScaleX(1);
        exit.setScaleY(1);

    }
    @FXML
    void enterExit(MouseEvent event) {
        exit.setScaleX(1.1);
        exit.setScaleY(1.1);
    }

    @FXML
    void enterBarbar(MouseEvent event) {
        barbar.setScaleX(1.1);
        barbar.setScaleY(1.1);
    }
    @FXML
    void enterGiant(MouseEvent event) {
        giant.setScaleX(1.1);
        giant.setScaleY(1.1);
    }
//    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pane1.setVisible(false);
    }
//    stage
    static Stage stage ;
    public static void setStage(Stage stage) {
        Heroes.stage = stage;
    }
    public static void closeStage () {
        stage.close();
    }
}
