module com.example.clashofclans {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.clashofclans to javafx.fxml;
    exports com.example.clashofclans;
    exports com.example.clashofclans.Model.Building;
    opens com.example.clashofclans.Model.Building to javafx.fxml;
    exports com.example.clashofclans.Model.Hero;
    opens com.example.clashofclans.Model.Hero to javafx.fxml;
    exports com.example.clashofclans.Attack;
    opens com.example.clashofclans.Attack to javafx.fxml;
    exports com.example.clashofclans.Attack.BuildingThreads;
    opens com.example.clashofclans.Attack.BuildingThreads to javafx.fxml;
    exports com.example.clashofclans.Personals;
    opens com.example.clashofclans.Personals to javafx.fxml;
    exports com.example.clashofclans.Attack.HeroThreads;
    opens com.example.clashofclans.Attack.HeroThreads to javafx.fxml;
    exports com.example.clashofclans.Model;
    opens com.example.clashofclans.Model to javafx.fxml;
    exports com.example.clashofclans.Attack.Maps;
    opens com.example.clashofclans.Attack.Maps to javafx.fxml;
}