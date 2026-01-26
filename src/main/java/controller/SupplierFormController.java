package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import dto.Supplyer;
import javafx.scene.control.cell.PropertyValueFactory;
import service.SupplyerService;
import service.impl.SupplyerServiceImpl;

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

    SupplyerService supplyerService = new SupplyerServiceImpl() {


        @FXML
        void btnAddSupplierOnAction(ActionEvent event) {
            Supplyer supplyer = new Supplyer(
                    txtSupplierID.getText(),
                    txtSupplierName.getText(),
                    txtPhoneNumber.getText(),
                    txtAddress.getText()

            );
            supplyerService.AddSupplyer(supplyer);
        }

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

        final ObservableList<Supplyer> supplyerList = FXCollections.observableArrayList();

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            colID.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone number"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

    }
}

