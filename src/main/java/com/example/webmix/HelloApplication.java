package com.example.webmix;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("first-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1720, 900);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setTitle("WEBMIX");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        final System.Logger LOGGER = System.getLogger(MainController.class.getName());
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent evt) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("프로그램 종료");
                alert.setHeaderText("오늘 하루 WEBMIX에서 즐거웠나요?");
                alert.setContentText("확인 버튼 클릭 시 자동으로 로그아웃됩니다.");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                } else if (result.get() == ButtonType.CANCEL) {
                    evt.consume();
                }
            }
        });
    }



    public static void main(String[] args) {
        launch();
    }
}