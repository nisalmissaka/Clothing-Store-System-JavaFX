package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashbordformController {

    @FXML
    private Label lblAdmin;

    @FXML
    private Label lblCashier;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    @FXML
    private Label lblGreeting;




    @FXML
    public void initialize(){
        startDateTime();
    }

    private void startDateTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),event -> {
                    LocalDateTime now = LocalDateTime.now();
                    lbldate.setText(now.format(dateFormatter));
                    lbltime.setText(now.format(timeFormatter));

                    int hour = now.getHour();
                    if (hour<12) {
                        lblGreeting.setText("Good Morning");
                    }else if (hour <17) {
                        lblGreeting.setText("Good Afternoon");
                    }else {
                        lblGreeting.setText("Good Evening");
                    }
                }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnOnActionDashBoard(ActionEvent event) {

    }

    Stage placeOrderStage = new Stage();
    @FXML
    void btnPOSOnAction(ActionEvent event) throws IOException {
        placeOrderStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/PlaceOrder.fxml"))));
        placeOrderStage.show();


    }

    @FXML
    void btnSettingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplyersOnAction(ActionEvent event) {

    }

    public Label getLblAdmin() {
        return lblAdmin;
    }

    public void setLblAdmin(Label lblAdmin) {
        this.lblAdmin = lblAdmin;
    }

    public Label getLblCashier() {
        return lblCashier;
    }

    public void setLblCashier(Label lblCashier) {
        this.lblCashier = lblCashier;
    }

    public Label getLbldate() {
        return lbldate;
    }

    public void setLbldate(Label lbldate) {
        this.lbldate = lbldate;
    }

    public Label getLbltime() {
        return lbltime;
    }

    public void setLbltime(Label lbltime) {
        this.lbltime = lbltime;
    }
}