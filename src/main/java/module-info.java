module com.example.bets_day8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bets_day8 to javafx.fxml;
    exports com.example.bets_day8;
}