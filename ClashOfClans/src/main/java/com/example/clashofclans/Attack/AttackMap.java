package com.example.clashofclans.Attack;

import com.example.clashofclans.Clash;
import com.example.clashofclans.Player;
import com.example.clashofclans.SQLClass;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class AttackMap implements Initializable {


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

    @FXML
    void clickedAttack(MouseEvent event) {
//        try {
//
//        } catch (IOException e){
//            System.out.println("error : " + e.getMessage());
//        }
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
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("personal.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("error : " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("error : " + e.getMessage());
        }
    }





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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        findTarget();
    }

    public static Stage stage ;

    private Player player ;
    private Player targetPlayer ;
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
}
