package com.example.clashofclans.Personals;

import com.example.clashofclans.Model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLClass {


    public static List <Player> players = new ArrayList <Player> () ;


    public static Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clash-of-clans", "root", "");
        return connection;
    }


    public static ResultSet readDataBase() throws SQLException, ClassNotFoundException {
        Statement statement = connection().createStatement();
        String text = "SELECT * from player";
        return statement.executeQuery(text);
    }

    public static void download(ResultSet rs) {
        try {
            while (rs.next()) {
                String name = rs.getString("user") ;
                String pass = rs.getString("pass") ;
                int map = rs.getInt("map") ;
                int level = rs.getInt("level") ;
                int wins = rs.getInt("wins") ;
                int losses = rs.getInt("losses") ;
                int profile = rs.getInt("profile") ;
                Player player = new Player(name , pass) ;
                player.setIndexMap(map);
                player.setLevel(level);
                player.setWins(wins);
                player.setLosses(losses);
                player.setIndexProfile(profile);
                players.add(player);
            }
            connection().close();
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void upDate (Player player) {
        for (Player temp : players) {
            if(temp.equals(player)) {
                temp = player ;
                System.out.println("up date done");
                break;
            }
        }
    }

    public static void upDateDataBase (Player player) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE 'player' SET 'level'=? , 'wins'=? , 'losses'=? , 'map'=? , 'profile'=? , WHERE 'user'=?" ;
        PreparedStatement statement = connection().prepareStatement(sql);
        statement.setInt(1 , player.getLevel());
        statement.setInt(2 , player.getWins());
        statement.setInt(3 , player.getLosses());
        statement.setInt(4 , player.getIndexMap());
        statement.setInt(5 , player.getIndexProfile());
        statement.setString(6 , player.getName());
        connection().close();
    }

    public static void upload () {
        for (Player player : players){
            try {
                uploadRow(player);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void uploadRow (Player player) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO player ('user' , 'pass' , 'map' , 'level' , 'wins' , 'losses' , 'profile' ) VALUES ('" + player.getName() + "','" + player.getPass() + "','" + player.getIndexMap() + "','" + player.getLevel() + "','" + player.getWins() + "','" + player.getLosses() + "','" + player.getIndexProfile() + "')";
        Statement s = connection().prepareStatement(sql) ;
        s.execute(sql) ;
        connection().close();
    }
}
