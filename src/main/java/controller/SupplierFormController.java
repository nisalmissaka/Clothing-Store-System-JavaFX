package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import dto.Supplyer;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableView<Supplyer> tblSupplier;

    @FXML
    private TextField txtAddress;

    @FXML
    private Label txtAdminName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtSupplierID;

    @FXML
    private TextField txtSupplierName;



    @FXML
    void btnAddSupplierOnAction(ActionEvent event) {

    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }


    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    // INITIALIZE METHOD
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Table Load or Init Setup
    }
}

