package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DashboardFormController {

    @FXML
    private Label lblAdmin;

    @FXML
    private Label lblDashboard;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblFLORENCE;

    @FXML
    private Label lblGoodMorning;

    @FXML
    private Label lblNisalMissaka;

    @FXML
    private Label lbltime;

    @FXML
    private Label lblGreeting;



    @FXML
    public void  initialize(){
        startDateTime();
    }

    private void startDateTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),event -> {
                    LocalDateTime now = LocalDateTime.now();
                    lblDate.setText(now.format(dateFormatter));
                    lbltime.setText(now.format(timeFormatter));

                    int hour = now.getHour();
                    if (hour>=0 && hour<10) {
                        lblGreeting.setText("Good Morning");
                    } else if (hour>=10 && hour < 15) {
                        lblGreeting.setText("Good Afternoon");
                    }else if (hour>=15 && hour < 19){
                        lblGreeting.setText("Good Evening");
                    } else {
                        lblGreeting.setText("Good Night");
                    }
                }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    void btnOnActionCustomers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/customer_form.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();


    }

    @FXML
    void btnOnActionItemManage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/item_form.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();


    }

    @FXML
    void btnOnActionOrders(ActionEvent event) {

    }

    @FXML
    void btnOnActionPOS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/PlaceOrder.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();



    }

    @FXML
    void btnOnActionSetting(ActionEvent event) {

    }

    @FXML
    void btnOnActionSupplyers(ActionEvent event) {

    }

}

