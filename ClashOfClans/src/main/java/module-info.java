module com.example.clashofclans {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.clashofclans to javafx.fxml;
    exports com.example.clashofclans;
    exports com.example.clashofclans.Building;
    opens com.example.clashofclans.Building to javafx.fxml;
    exports com.example.clashofclans.Hero;
    opens com.example.clashofclans.Hero to javafx.fxml;
    exports com.example.clashofclans.Attack;
    opens com.example.clashofclans.Attack to javafx.fxml;
}