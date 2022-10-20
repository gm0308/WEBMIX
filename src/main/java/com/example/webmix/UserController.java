package com.example.webmix;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserController {


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

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    @FXML
    private TextField id;
    @FXML
    private PasswordField pw;
    @FXML
    private TextField name;
    @FXML
    private Button JoinBtn;

    public void insertMember() {
        DB db = new DB();

        Connection conn = db.getConnection();

        PreparedStatement pstmt = null;

        String sql = "INSERT INTO users(id, pw, name) VALUES(?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id.getText());
            pstmt.setString(2, pw.getText());
            pstmt.setString(3, name.getText());
            pstmt.executeUpdate();
            alert.setHeaderText("회원가입이 성공되셨습니다");
            alert.setResizable(true);
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            alert.setHeaderText("중복된 아이디가 있습니다");
            alert.setResizable(true);
            alert.showAndWait();
        }
    }
}
