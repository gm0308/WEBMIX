package com.example.webmix;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Label NewLogin;
    public void NewLoginScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("NewLogin-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) NewLogin.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}