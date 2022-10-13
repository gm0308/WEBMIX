package com.example.webmix;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Label MovieTxt;
    public void MovieScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Movie-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) MovieTxt.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label TVProgramTxt;
    public void TVScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("TV-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) TVProgramTxt.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label HomeTxt;
    public void HomeScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Main-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) HomeTxt.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    javafx 화면 슬라이스 애니메이션
}
