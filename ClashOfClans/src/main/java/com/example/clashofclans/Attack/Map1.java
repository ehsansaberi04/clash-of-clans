package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.*;
import com.example.clashofclans.Hero.* ;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    void clickedMap(MouseEvent event) {
        switch (heroNumber) {
            case 1->{
                Barbarian barbarian = new Barbarian ();
                ImageView temp = new ImageView();
                temp.setImage(barbarian.imageView.getImage());
                temp.setFitHeight(40);
                temp.setFitWidth(40);
                temp.setX(event.getX()-20);
                temp.setY(event.getY()-20);
                temp.setVisible(true);
                pane.getChildren().add(temp) ;
                ThreadBarbar threadBarbar = new ThreadBarbar(barbarian , temp) ;
                Thread thread = new Thread(threadBarbar) ;
                War.armies.add(barbarian);
                thread.start();
            }
            case 2->{
                Archer archer = new Archer() ;
                ImageView temp = new ImageView();
                temp.setImage(archer.imageView.getImage());
                temp.setFitHeight(40);
                temp.setFitWidth(40);
                temp.setX(event.getX()-20);
                temp.setY(event.getY()-20);
                temp.setVisible(true);
                pane.getChildren().add(temp) ;
                ThreadArcher threadArcher = new ThreadArcher(archer , temp) ;
                Thread thread = new Thread(threadArcher) ;
                War.armies.add(archer);
                thread.start();
            }
            case 3->{
                Giant giant = new Giant() ;
                ImageView temp = new ImageView();
                temp.setImage(giant.imageView.getImage());
                temp.setFitHeight(40);
                temp.setFitWidth(40);
                temp.setX(event.getX()-20);
                temp.setY(event.getY()-20);
                temp.setVisible(true);
                pane.getChildren().add(temp) ;
                ThreadGiant threadGiant = new ThreadGiant(giant , temp) ;
                Thread thread = new Thread(threadGiant) ;
                War.armies.add(giant);
                thread.start();
            }
            case 4->{
                Pekka pekka = new Pekka() ;
                ImageView temp = new ImageView();
                temp.setImage(pekka.imageView.getImage());
                temp.setFitHeight(40);
                temp.setFitWidth(40);
                temp.setX(event.getX()-20);
                temp.setY(event.getY()-20);
                temp.setVisible(true);
                pane.getChildren().add(temp) ;
                ThreadPekka threadPekka = new ThreadPekka(pekka , temp) ;
                Thread thread = new Thread(threadPekka) ;
                War.armies.add(pekka);
                thread.start();
            }
            default ->{}
        }

    }

    @FXML
    void enterBackPane1(MouseEvent event) {

    }

    @FXML
    void enterCArcher(MouseEvent event) {

    }

    @FXML
    void enterCBarbar(MouseEvent event) {

    }

    @FXML
    void enterCGiant(MouseEvent event) {

    }

    @FXML
    void enterCPekka(MouseEvent event) {

    }

    @FXML
    void enterHArcher(MouseEvent event) {

    }

    @FXML
    void enterHBarbar(MouseEvent event) {

    }

    @FXML
    void enterHGiant(MouseEvent event) {

    }

    @FXML
    void enterHPekka(MouseEvent event) {

    }

    private int heroNumber ;

//    public static List<ImageView> buildings = new ArrayList<ImageView>() ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pane1.setVisible(false);
        heroPane.setVisible(true);
        startWar();
    }

    private void startWar () {
//        class
        Cannon c1 = new Cannon(cannon1);
        Cannon c2 = new Cannon(cannon2);
        ArcherTower at1 = new ArcherTower(archerTower);
        ElixirMaker ex1 = new ElixirMaker(elixirCollector1);
        ElixirMaker ex2 = new ElixirMaker(elixirCollector2);
        Maker m1 = new Maker(maker) ;
        TownHall th1 = new TownHall(townHall) ;
//       added
        War.buildings.add(c1);
        War.buildings.add(c2);
        War.buildings.add(at1);
        War.buildings.add(ex1);
        War.buildings.add(ex2);
        War.buildings.add(m1);
        War.buildings.add(th1);
//        images
        War.images.add(c1.imageView);
        War.images.add(c2.imageView);
        War.images.add(at1.imageView);
        War.images.add(ex1.imageView);
        War.images.add(ex1.imageView);
        War.images.add(m1.imageView);
        War.images.add(th1.imageView);
//        runnable
        ThreadCannon threadCannon1 = new ThreadCannon(c1 , cannon1) ;
        ThreadCannon threadCannon2 = new ThreadCannon(c2 , cannon2) ;
        ThreadArcherTower threadArcherTower1 = new ThreadArcherTower(at1 , archerTower) ;
//        thread
        Thread t1 = new Thread(threadCannon1);
        Thread t2 = new Thread(threadCannon2);
        Thread t3 = new Thread(threadArcherTower1);
//        start
        t1.start();
        t2.start();
        t3.start();
    }
}
