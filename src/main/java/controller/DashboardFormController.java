package controller;

import db.DBConnection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    private Label lblAdmin;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblFLORENCE;
    @FXML
    private Label lblGreeting;
    @FXML
    private Label lblNisalMissaka;
    @FXML
    private Label lbltime;

    @FXML
    void btnOnActionCustomers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/customer_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Customer Management");
        stage.show();
    }

    @FXML
    void btnOnActionItemManage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/item_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Item Management");
        stage.show();
    }

    @FXML
    void btnOnActionPOS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/place_order_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("POS System");
        stage.show();
    }
    @FXML
    void btnOnActionSelesReport(ActionEvent event) {
        try {
            JasperDesign design = JRXmlLoader.load("src/main/resources/View/report/Nisal.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);

            JRDesignQuery jrDesignQuery = new JRDesignQuery();
            jrDesignQuery.setText("SELECT Description,ItemPrice,Discount,Quantity FROM item WHERE ItemCode=?");
            design.setQuery(jrDesignQuery);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperExportManager.exportReportToPdfFile(jasperPrint,"sales_report.pdf");
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void btnOnActionSetting(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/setting_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Setting");
        stage.show();
    }

    @FXML
    void btnOnActionSupplyers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/supplyer_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Supplier Management");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startDateTime();
    }

    private void startDateTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> {
                    LocalDateTime now = LocalDateTime.now();
                    lblDate.setText(now.format(dateFormatter));
                    lbltime.setText(now.format(timeFormatter));

                    int hour = now.getHour();
                    if (hour >= 0 && hour < 12) {
                        lblGreeting.setText("Good Morning");
                    } else if (hour >= 12 && hour < 16) {
                        lblGreeting.setText("Good Afternoon");
                    } else if (hour >= 16 && hour < 19) {
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
}