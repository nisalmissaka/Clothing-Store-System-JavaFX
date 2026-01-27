package controller;

import dto.Supplyer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.SupplyerService;
import service.impl.SupplyerServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplyerFormController implements Initializable {



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

    public TextField txtSupplyerEmail;


    @FXML
    void btnAddSupplyerOnAction(ActionEvent event) {
        Supplyer supplyer = new Supplyer(
                txtSupplyerID.getText(),
                txtSupplyerName.getText(),
                txtCompanyName.getText(),
                txtSupplyerBrand.getText(),
                txtContactNumber.getText(),
                txtSupplyerEmail.getText()
        );
        SupplyerService.AddSuplier(supplyer);

    }

    @FXML
    void btnDeleteSupplyerOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
