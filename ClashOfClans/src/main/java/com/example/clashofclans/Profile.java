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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Profile implements Initializable {


    @FXML
    private ImageView back;

    @FXML
    private ImageView backPane1;

    @FXML
    private ImageView comeBack;

    @FXML
    private Text infoText;

    @FXML
    private Text levelText;

    @FXML
    private Text lostText;

    @FXML
    private Text nameText;

    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private ImageView p3;

    @FXML
    private ImageView p4;

    @FXML
    private AnchorPane pane;

    @FXML
    private Pane pane1;

    @FXML
    private Text passText;

    @FXML
    private ImageView profile;

    @FXML
    private Text winText;

    @FXML
    void clicked1(MouseEvent event) {
        indexProfile = 1 ;
        pane1.setVisible(false);
        profile.setVisible(true);
        setImageProfile();
    }

    @FXML
    void clicked2(MouseEvent event) {
        indexProfile = 2 ;
        pane1.setVisible(false);
        profile.setVisible(true);
        setImageProfile();
    }

    @FXML
    void clicked3(MouseEvent event) {
        indexProfile = 3 ;
        pane1.setVisible(false);
        profile.setVisible(true);
        setImageProfile();
    }

    @FXML
    void clicked4(MouseEvent event) {
        indexProfile = 4 ;
        pane1.setVisible(false);
        profile.setVisible(true);
        setImageProfile();
    }

    @FXML
    void clickedComeBack(MouseEvent event) {
        if(profile.isVisible()) {
            try {
                Personal.getPlayer().setIndexProfile(indexProfile);
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("personal.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    void clickedProfile(MouseEvent event) {
        profile.setVisible(false);
        pane1.setVisible(true);
    }

    private static int indexProfile ;
    private Player player ;

    public static int getIndexProfile() {
        return indexProfile;
    }

    private void setImageProfile () {
        String address ;
        switch (indexProfile){
            case 1 ->{
                address = "image/p1.jpg" ;
            }
            case 2 ->{
                address = "image/p2.jpg" ;
            }
            case 3 ->{
                address = "image/p3.jpg" ;
            }
            case 4 ->{
                address = "image/p4.jpg" ;
            }
            default ->{
                address = "image/p0.png" ;
            }
        }
        profile.setImage(new Image(Clash.class.getResource(address).toString()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        indexProfile = Personal.getPlayer().getIndexProfile() ;
        String address ;
        switch (indexProfile) {
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
        player = Personal.getPlayer() ;
        levelText.setText("lvl" + player.getLevel());
        nameText.setText("name : " + player.getName());
        passText.setText("pass : " + player.getPass());
        winText.setText("your wins : " + player.getWins());
        lostText.setText("your losses : " + player.getLosses());

    }
}
