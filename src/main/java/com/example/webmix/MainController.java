package com.example.webmix;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    @FXML
    private ImageView popView;
    @FXML
    private Button mainBtn;
    @FXML
    private Stage pop;
    public void popup() {
        Stage mainStage = (Stage) popView.getScene().getWindow();

        pop = new Stage(StageStyle.DECORATED);
        pop.initModality(Modality.WINDOW_MODAL);
        pop.initOwner(mainStage);

        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("User-view.fxml"));

            Scene scene = new Scene(nextScene);
            pop.setScene(scene);
            pop.setTitle("User");
            pop.setResizable(false);
            pop.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        pop = (Stage) mainBtn.getScene().getWindow();
        pop.close();
    }

    @FXML
    private Label LogTxt;

    public void Logout() {
        try     {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("first-view.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) LogTxt.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
