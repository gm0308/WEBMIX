package com.example.webmix;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;

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
            System.out.println("회원로그인이 되었습니다");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("같은 아이디가 있습니다");
        }
    }
}