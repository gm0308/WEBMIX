package com.example.webmix;

import javafx.event.ActionEvent;
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

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    @FXML
    private TextField id;
    @FXML
    private PasswordField pw;
    @FXML
    private Button LoginBtn;

    public void LoginAction(ActionEvent event) {
        String ID = this.id.getText();
        String PW = this.pw.getText();
        String Url = "jdbc:mysql://localhost:3306/yydh";
        String bID = "root";
        String dPW = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Url, bID, dPW);
            sql = "select id,pw from users where id = ? and pw = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ID);
            pstmt.setString(2, PW);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            }
            if (rs.getString("id").equals(ID) && rs.getString("pw").equals(PW)) {

                alert.setHeaderText("welcome to WEBMIX ");
                alert.setResizable(true);
                alert.showAndWait();

                Parent nextScene
                        = FXMLLoader.load(getClass().getResource("Main-view.fxml"));
                Scene scene = new Scene(nextScene);
                Stage primaryStage = (Stage) LoginBtn.getScene().getWindow();
                primaryStage.setScene(scene);
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
