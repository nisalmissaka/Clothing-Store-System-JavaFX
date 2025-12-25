package controller;

import db.DBConnection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;
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
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Customers");
        stage.show();


    }

    @FXML
    void btnOnActionItemManage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/item_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("ItemManage");
        stage.show();


    }

    @FXML
    void btnOnActionSalesReport(ActionEvent event) {
        try {
            JasperDesign design = JRXmlLoader.load("src/main/resources/View/report/Nisal.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint);

        } catch (JRException | SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void btnOnActionPOS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/place_order_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("POS");
        stage.show();

    }

    @FXML
    void btnOnActionSetting(ActionEvent event) {

    }

    @FXML
    void btnOnActionSupplyers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/supplyers_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Supplyers");
        stage.show();

    }

}



