package com.example.clashofclans;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.* ;
import java.util.Objects;

public class Login {


    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button singUpButton;

    @FXML
    void ClickedCancel(MouseEvent event) {
        nameField.setText("");
        passField.setText("");
    }


    @FXML
    void clickedUp(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        String userName = nameField.getText();
        String passWord = nameField.getText();
        if (/*checkUser(userName , readDataBase())*/ true) {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-map.fxml"))) ;
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
            Scene scene = new Scene(parent) ;
            stage.setScene(scene);
            stage.show();
        }
    }


    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clash-of-clans", "root", "");
        return connection;
    }

    public ResultSet readDataBase() throws SQLException, ClassNotFoundException {
        Statement statement = connection().createStatement();
        String text = "SELECT * from player";
        return statement.executeQuery(text);
    }


    private boolean checkUser(String user, ResultSet rs) {
        try {
            while (rs.next()) {
                if (rs.getString("user").equals(user)) {
                    return false;
                }
            }
            connection().close();
        } catch (SQLException e) {
            System.out.println("error");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void saveDatabase (Player player) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO player ('user' , 'pass' , 'map' , 'level' ) VALUES ('" + player.getName() + "','" + player.getPass() + "','" + player.getPass() + "','" + player.getLevel() + "')";
        Statement s = connection().prepareStatement(sql) ;
        s.execute(sql) ;
        connection().close();
    }
}