package com.example.webmix;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.PrintWriter;
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
            alert.setHeaderText("같은 아이디가 있습니다");
            alert.setResizable(true);
            alert.showAndWait();
        }
    }

//    로그인

    @FXML
    private Button LoginBtn;
    public void LoginAction(ActionEvent event) {
        String ID = this.id.getText();
        String PW = this.pw.getText();
        String Url = "jdbc:mysql://localhost:3306/webmix";
        String bID = "root";
        String dPW = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.users");
            conn = DriverManager.getConnection(Url, bID, dPW);
            sql = "select id,pw from webmix_users where id = ? and pw = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,ID);
            pstmt.setString(2,PW);
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getString("id").equals(ID) && rs.getString("pw").equals(PW)) {
                Parent mainPage = (Parent) FXMLLoader.load(this.getClass().getResource("main-view"));
                StackPane root = (StackPane) this.LoginBtn.getScene().getRoot();
                root.getChildren().add(mainPage);
            }
        } catch (Exception var25) {
            var25.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ver24) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException var23) {
                }
            }
        }
    }

}