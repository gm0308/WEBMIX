package com.example.webmix;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    @FXML
    private Button LoginBtn;
    public void LoginScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("main-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) LoginBtn.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button MainBtn;
    public void MainScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("first-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) MainBtn.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label MainTxt;
    public void MainLabelScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("first-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) MainTxt.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}