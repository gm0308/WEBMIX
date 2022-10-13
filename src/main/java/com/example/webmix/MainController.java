package com.example.webmix;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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
    private AnchorPane container;
    @FXML
    private ImageView UserImg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    }
    }

    @FXML
    private void open_registration_form(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User-view.fxml"));

        Scene scene = UserImg.getScene();

        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) scene.getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            parentContainer.getChildren().remove(container);
        });
        timeline.play();
    }

}
