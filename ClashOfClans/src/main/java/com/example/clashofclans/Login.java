package com.example.clashofclans;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.* ;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Border;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.* ;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.* ;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Login implements Initializable {


    @FXML
    private Button singInButton;
    @FXML
    private Button singUpButton;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passField;
    @FXML
    private Text textException;

    @FXML
    void ClickedSingIn(MouseEvent event) {
        String userName = nameField.getText();
        String passWord = passField.getText();
        if(check(userName) && check(passWord)){
            try {
                Player player1 = checkSignIn(userName, passWord);
                player = player1 ;
                Personal.setPlayer(player);
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("personal.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (NullPointerException e) {
                textException.setText("کاربری با این نام یافت نشد");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            textException.setText("مقادیر وارد شده قابل قبول نیست");
        }
    }
    @FXML
    void clickedUp(MouseEvent event) {
        String userName = nameField.getText();
        String passWord = nameField.getText();
        try {
            if (check(userName) && check(passWord)) {
                if (checkSignUp(userName, passWord)) {
                    Player player1 = new Player(userName, passWord);
                    player1.setLevel(1);
                    player1.setWins(0);
                    player1.setLosses(0);
                    player = player1 ;
                    Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-map.fxml")));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    textException.setText("این نام کاربری قبلا ثبت شده است");
                }
            } else {
                textException.setText("نام کاربری یا گذرواژه مورد قبول نیست");
            }
        } catch (IOException e) {
            textException.setText("error");
        }
    }

    @FXML
    void enterIn(MouseEvent event) {

    }
    @FXML
    void enterUp(MouseEvent event) {

    }

    private static Player player ;

    public static Player getPlayer() {
        return player;
    }

    private boolean check (String line) {
        boolean regex1 = Pattern.matches(".+" , line) ;
//        boolean regex2 = Pattern.matches("\\d*" , line) ;
        return regex1 ;
    }
    private boolean checkSignUp (String user , String pass) {
        for (Player player1 : SQLClass.players) {
            if(player1.getName().equals(user)){
                return false ;
            }
        }
        return true ;
    }
    private Player checkSignIn (String user , String pass) {
        for (Player player1 : SQLClass.players) {
            if(player1.getName().equals(user)){
                if (player1.getPass().equals(pass)){
                    return player1 ;
                }
            }
        }
        throw new NullPointerException() ;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player = null ;
        try {
            SQLClass.download(SQLClass.readDataBase()) ;
        } catch (SQLException e) {
            textException.setText("error sql");
        } catch (ClassNotFoundException e) {
            textException.setText("error class not found");
        }
    }
}
