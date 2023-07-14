package com.example.clashofclans;

import com.example.clashofclans.Attack.Maps.Map1;
import com.example.clashofclans.Model.Player;
import com.example.clashofclans.Personals.Login;
import com.example.clashofclans.Personals.SQLClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Clash extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("login.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(Clash.class.getResource("map1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stg = stage ;
        stg.setScene(scene);
        stg.show();
        Login.setStage(stg);
        Map1.setStage(stg);
    }
    public static void main(String[] args) {
//        i will clear here
        add("ali","ali",1,1);
        add("ehsan","ehsan",2,2);
        add("sajad","sajad",3,3);
        add("mehr","mehr",4,4);
        f(SQLClass.players.get(0));
        f(SQLClass.players.get(1));
        f(SQLClass.players.get(2));
        f(SQLClass.players.get(3));
//        --------------------------
        launch();
    }
    static Stage stg ;
//    i will clear here
    public static void add(String name, String pass, int map, int pro) {
        Player player = new Player(name , pass);
        player.setIndexMap(map);
        player.setIndexProfile(pro);
        SQLClass.players.add(player);
    }
    public static void f (Player player) {
        System.out.println(player.getName());
    }
}