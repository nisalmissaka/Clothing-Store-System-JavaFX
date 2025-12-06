package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    private TextField txtUserName;


    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        if (username.equals("nisal") && password.equals("1234")) {

            try {

                Scene dashboardScene = new Scene(
                        FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))
                );

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(dashboardScene);
                stage.setTitle("Dashboard");
                stage.centerOnScreen();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            lblError.setText("Invalid username or password");
        }
    }
}


