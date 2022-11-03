module com.atv1.asaida {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.atv1.asaida to javafx.fxml;
    exports com.atv1.asaida;
}