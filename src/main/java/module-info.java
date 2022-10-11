module com.example.webmix {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.webmix to javafx.fxml;
    exports com.example.webmix;
}