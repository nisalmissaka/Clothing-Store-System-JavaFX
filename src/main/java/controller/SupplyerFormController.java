package controller;

import dto.Supplyer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Supplyer,String> colSupplyerID;

    @FXML
    private TableColumn<?, ?> colSupplyerName;

    @FXML
    private TableView<Supplyer> tblSupplyer;

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

    SupplyerService supplyerService = new SupplyerServiceImpl();


    @FXML
    void btnAddSupplyerOnAction(ActionEvent event) {
        Supplyer supplyer = new Supplyer(
                txtSupplyerID.getText(),
                txtSupplyerName.getText(),
                txtCompanyName.getText(),
                txtContactNumber.getText(),
                txtSupplyerEmail.getText(),
                txtSupplyerBrand.getText()
        );
       boolean isAdded =  SupplyerService.AddSuplier(supplyer);

       if (isAdded){
           clearFields();
       }

    }

    private void clearFields() {

    }

    @FXML
    void btnDeleteSupplyerOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    ObservableList<Supplyer>supplyerObservableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupplyerID.setCellValueFactory(new PropertyValueFactory<>("supplyerID"));
        colSupplyerName.setCellValueFactory(new PropertyValueFactory<>("supplyerName"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colCantactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colSupplyerEmail.setCellValueFactory(new PropertyValueFactory<>("supplyerEmail"));
        colSupplyerBrand.setCellValueFactory(new PropertyValueFactory<>("supplyerBrand"));

        tblSupplyer.setItems(supplyerObservableList);
        loadTable();


    }

    private void loadTable() {
        supplyerObservableList.clear();
    }
}
