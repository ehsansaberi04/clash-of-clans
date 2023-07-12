package com.example.clashofclans.Attack.Maps;

import com.example.clashofclans.Attack.BuildingThreads.*;
import com.example.clashofclans.Attack.HeroThreads.ThreadArcher;
import com.example.clashofclans.Attack.HeroThreads.ThreadBarbar;
import com.example.clashofclans.Attack.HeroThreads.ThreadGiant;
import com.example.clashofclans.Attack.HeroThreads.ThreadPekka;
import com.example.clashofclans.Attack.War;
import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Hero.* ;
import com.example.clashofclans.Personals.Personal;
import com.example.clashofclans.Personals.SQLClass;
import com.example.clashofclans.Model.Player;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Map1 implements Initializable {
    @FXML
    private Text archerText;
    @FXML
    private ImageView archerTower;
    @FXML
    private ImageView back;
    @FXML
    private ImageView backPane1;
    @FXML
    private Text barbarText;
    @FXML
    private ImageView cannon1;
    @FXML
    private ImageView cannon2;
    @FXML
    private ImageView cartArcher;
    @FXML
    private ImageView cartBarbar;
    @FXML
    private ImageView cartGiant;
    @FXML
    private ImageView cartPekka;
    @FXML
    private ImageView elixirCollector1;
    @FXML
    private ImageView elixirCollector2;
    @FXML
    private Text giantText;
    @FXML
    private ImageView heroArcher;
    @FXML
    private ImageView heroBarbar;
    @FXML
    private ImageView heroGiant;
    @FXML
    private Pane heroPane;
    @FXML
    private ImageView heroPekka;
    @FXML
    private ImageView maker;
    @FXML
    private ImageView backPaneEndGame;
    @FXML
    private ImageView exitEndGame;
    @FXML
    private ImageView goldStar;
    @FXML
    private Pane paneEndGame;
    @FXML
    private ImageView redStar;

    @FXML
    private Text textInfo;
    @FXML
    private ImageView map;
    @FXML
    private AnchorPane pane;
    @FXML
    private Pane pane1;
    @FXML
    private Text pekkaText;
    @FXML
    private ImageView townHall;

    @FXML
    void clickedCArcher(MouseEvent event) {

    }
    @FXML
    void clickedCBarbar(MouseEvent event) {

    }
    @FXML
    void clickedCGiant(MouseEvent event) {

    }
    @FXML
    void clickedCPekka(MouseEvent event) {

    }
    @FXML
    void clickedHBarbar(MouseEvent event) {
        heroNumber = 1 ;
    }

    @FXML
    void clickedHArcher(MouseEvent event) {
        heroNumber = 2 ;
    }

    @FXML
    void clickedHGiant(MouseEvent event) {
        heroNumber = 3 ;
    }

    @FXML
    void clickedHPekka(MouseEvent event) {
        heroNumber = 4 ;
    }
    @FXML
    void clickedExitEndGame(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("Personal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            Personal.setStage(stage);
            Personal.setPlayer(player);
            SQLClass.upDate(player);
            SQLClass.upDate(target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void clickedMap(MouseEvent event) {
        switch (heroNumber) {
            case 1->{
                if(barbarNumber > 0) {
                    ImageView temp = new ImageView();
                    temp.setImage(Barbarian.imageView.getImage());
                    temp.setFitHeight(40);
                    temp.setFitWidth(40);
                    temp.setX(event.getX() - 20);
                    temp.setY(event.getY() - 20);
                    temp.setVisible(true);
                    pane.getChildren().add(temp);
                    ThreadBarbar threadBarbar = new ThreadBarbar(temp);
                    Platform.runLater(threadBarbar);
                    barbarNumber -- ;
                }
            }
            case 2->{
                if(giantNumber > 0) {
                    ImageView temp = new ImageView();
                    temp.setImage(Archer.imageView.getImage());
                    temp.setFitHeight(40);
                    temp.setFitWidth(40);
                    temp.setX(event.getX() - 20);
                    temp.setY(event.getY() - 20);
                    temp.setVisible(true);
                    pane.getChildren().add(temp);
                    ThreadArcher threadArcher = new ThreadArcher(temp , pane);
                    Platform.runLater(threadArcher);
                    archerNumber -- ;
                }
            }
            case 3->{
                if(giantNumber > 0) {
                    ImageView temp = new ImageView();
                    temp.setImage(Giant.imageView.getImage());
                    temp.setFitHeight(40);
                    temp.setFitWidth(40);
                    temp.setX(event.getX() - 20);
                    temp.setY(event.getY() - 20);
                    temp.setVisible(true);
                    pane.getChildren().add(temp);
                    ThreadGiant threadGiant = new ThreadGiant(temp);
                    Platform.runLater(threadGiant);
                    giantNumber -- ;
                }
            }
            case 4->{
                if(pekkaNumber > 0) {
                    ImageView temp = new ImageView();
                    temp.setImage(Pekka.imageView.getImage());
                    temp.setFitHeight(40);
                    temp.setFitWidth(40);
                    temp.setX(event.getX() - 20);
                    temp.setY(event.getY() - 20);
                    temp.setVisible(true);
                    pane.getChildren().add(temp);
                    ThreadPekka threadPekka = new ThreadPekka(temp);
                    Platform.runLater(threadPekka);
                    pekkaNumber -- ;
                }
            }
            default ->{}
        }
    }
//    enter
    @FXML
    void enterBack(MouseEvent event) {
        heroArcher.setScaleX(1);
        heroArcher.setScaleY(1);
        heroBarbar.setScaleX(1);
        heroBarbar.setScaleY(1);
        heroGiant.setScaleX(1);
        heroGiant.setScaleY(1);
        heroPekka.setScaleX(1);
        heroPekka.setScaleY(1);
    }
    @FXML
    void enterBackPane1(MouseEvent event) {
        cartArcher.setScaleX(1);
        cartArcher.setScaleY(1);
        cartBarbar.setScaleX(1);
        cartBarbar.setScaleY(1);
        cartGiant.setScaleX(1);
        cartGiant.setScaleY(1);
        cartPekka.setScaleX(1);
        cartPekka.setScaleY(1);
    }
    @FXML
    void enterCArcher(MouseEvent event) {
        cartArcher.setScaleX(1.1);
        cartArcher.setScaleY(1.1);
    }
    @FXML
    void enterCBarbar(MouseEvent event) {
        cartBarbar.setScaleX(1.1);
        cartBarbar.setScaleY(1.1);
    }
    @FXML
    void enterCGiant(MouseEvent event) {
        cartGiant.setScaleX(1.1);
        cartGiant.setScaleY(1.1);
    }
    @FXML
    void enterCPekka(MouseEvent event) {
        cartPekka.setScaleX(1.1);
        cartPekka.setScaleY(1.1);
    }
    @FXML
    void enterHeroPane(MouseEvent event) {
        heroArcher.setScaleX(1);
        heroArcher.setScaleY(1);
        heroBarbar.setScaleX(1);
        heroBarbar.setScaleY(1);
        heroGiant.setScaleX(1);
        heroGiant.setScaleY(1);
        heroPekka.setScaleX(1);
        heroPekka.setScaleY(1);
    }
    @FXML
    void enterHArcher(MouseEvent event) {
        heroArcher.setScaleX(1.1);
        heroArcher.setScaleY(1.1);
        heroBarbar.setScaleX(1);
        heroBarbar.setScaleY(1);
        heroGiant.setScaleX(1);
        heroGiant.setScaleY(1);
        heroPekka.setScaleX(1);
        heroPekka.setScaleY(1);
    }
    @FXML
    void enterHBarbar(MouseEvent event) {
        heroBarbar.setScaleX(1.1);
        heroBarbar.setScaleY(1.1);
        heroArcher.setScaleX(1);
        heroArcher.setScaleY(1);
        heroGiant.setScaleX(1);
        heroGiant.setScaleY(1);
        heroPekka.setScaleX(1);
        heroPekka.setScaleY(1);
    }
    @FXML
    void enterHGiant(MouseEvent event) {
        heroGiant.setScaleX(1.1);
        heroGiant.setScaleY(1.1);
        heroArcher.setScaleX(1);
        heroArcher.setScaleY(1);
        heroBarbar.setScaleX(1);
        heroBarbar.setScaleY(1);
        heroPekka.setScaleX(1);
        heroPekka.setScaleY(1);
    }
    @FXML
    void enterHPekka(MouseEvent event) {
        heroPekka.setScaleX(1.1);
        heroPekka.setScaleY(1.1);
        heroArcher.setScaleX(1);
        heroArcher.setScaleY(1);
        heroBarbar.setScaleX(1);
        heroBarbar.setScaleY(1);
        heroGiant.setScaleX(1);
        heroGiant.setScaleY(1);
    }
    @FXML
    void enterMap(MouseEvent event) {
        heroArcher.setScaleX(1);
        heroArcher.setScaleY(1);
        heroBarbar.setScaleX(1);
        heroBarbar.setScaleY(1);
        heroGiant.setScaleX(1);
        heroGiant.setScaleY(1);
        heroPekka.setScaleX(1);
        heroPekka.setScaleY(1);
    }
//    other function

    public void setTexts () {
        barbarText.setText(String.valueOf(barbarNumber));
        archerText.setText(String.valueOf(archerNumber));
        giantText.setText(String.valueOf(giantNumber));
        pekkaText.setText(String.valueOf(pekkaNumber));
        if (barbarNumber==0){
            heroBarbar.setVisible(false);
            barbarText.setVisible(false);
        }
        if (archerNumber==0){
            heroArcher.setVisible(false);
            archerText.setVisible(false);
        }
        if (giantNumber==0){
            heroGiant.setVisible(false);
            giantText.setVisible(false);
        }
        if (pekkaNumber==0){
            heroPekka.setVisible(false);
            pekkaText.setVisible(false);
        }
    }
    private int heroNumber ;
    private static int barbarNumber = 5 ;
    private static int archerNumber = 1 ;
    private static int giantNumber = 1 ;
    private static int pekkaNumber = 1 ;
    private static int remain ;
    public static int setRemain() {
        remain = barbarNumber + archerNumber + giantNumber + pekkaNumber + War.armies.size() ;
        return remain ;
    }
    private static Player player ;
    private static Player target ;

    public static void setPlayer(Player temp) {
        player = temp;
    }
    public static void setTarget(Player temp) {
        Map1.target = temp;
    }
    public static boolean endGame = false ;
    public static boolean attackerWinn = false ;
    public void endShow () {
        endGame = true ;
        paneEndGame.setVisible(true);
        if(attackerWinn) {
            player.addWin();
            target.addLost();
            goldStar.setVisible(true);
            textInfo.setText("you won");
        } else {
            player.addLost();
            target.addWin();
            redStar.setVisible(true);
            textInfo.setText("you lost");
        }
        try {
            SQLClass.upDateDataBase(player);
            SQLClass.upDateDataBase(target);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
//    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        War.clear();
        pane1.setVisible(false);
        heroPane.setVisible(true);
        setRemain();
        startWar();
        ThreadAttack1 attack = new ThreadAttack1(this);
        Thread thread = new Thread(attack);
        thread.start();
    }

    private void startWar () {
//        archer tower
        ThreadArcherTower threadArcherTower = new ThreadArcherTower(archerTower);
        Thread t1 = new Thread(threadArcherTower) ;
        t1.start();
//   cannons
        ThreadCannon threadCannon1 = new ThreadCannon(cannon1);
        Thread t2 = new Thread(threadCannon1);
        t2.start();
        ThreadCannon threadCannon2 = new ThreadCannon(cannon2);
        Thread t3 = new Thread(threadCannon2);
        t3.start();
//        elixir maker
        ThreadElixirMaker threadElixirMaker1 = new ThreadElixirMaker(elixirCollector1) ;
        Thread t4 = new Thread(threadElixirMaker1);
        t4.start();
        ThreadElixirMaker threadElixirMaker2 = new ThreadElixirMaker(elixirCollector2) ;
        Thread t5 = new Thread(threadElixirMaker2);
        t5.start();
//        maker
        ThreadMaker threadMaker = new ThreadMaker(maker);
        Thread t6 = new Thread(threadMaker) ;
        t6.start();
//        town hall
        ThreadTownHall threadTownHall = new ThreadTownHall(townHall);
        Thread t7 = new Thread(threadTownHall);
        t7.start();
    }
//    stage
    static Stage stage ;
    public static void setStage(Stage stage) {
        Map1.stage = stage;
    }
    public static Stage getStage() {
        return stage;
    }
}
