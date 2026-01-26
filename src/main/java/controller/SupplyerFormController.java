package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SupplyerFormController {

    @FXML
    private TextField SupplyerEmail;

    @FXML
    private TableColumn<?, ?> colCantactNumber;

    @FXML
    private TableColumn<?, ?> colCompanyName;

    @FXML
    private TableColumn<?, ?> colSupplyerBrand;

    @FXML
    private TableColumn<?, ?> colSupplyerEmail;

    @FXML
    private TableColumn<?, ?> colSupplyerID;

    @FXML
    private TableColumn<?, ?> colSupplyerName;

    @FXML
    private TableView<?> tblSupplyer;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtContactNumber;

    @FXML
    private TextField txtSupplyerBrand;

    @FXML
    private TextField txtSupplyerID;

    @FXML
    private TextField txtSupplyerName;

    @FXML
    void btnAddSupplyerOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteSupplyerOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

}
