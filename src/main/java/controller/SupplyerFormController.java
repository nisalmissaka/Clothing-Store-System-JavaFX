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
import repository.SupplyerRepository;
import repository.impl.SupplyerRepositoryImpl;
import service.SupplyerService;
import service.impl.SupplyerServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;




public class SupplyerFormController implements Initializable {

    @FXML
    private TableColumn<Supplyer, String> colCantactNumber;

    @FXML
    private TableColumn<Supplyer, String> colCompanyName;

    @FXML
    private TableColumn<Supplyer, String> colSupplyerBrand;

    @FXML
    private TableColumn<Supplyer, String> colSupplyerEmail;

    @FXML
    private TableColumn<Supplyer, String> colSupplyerID;

    @FXML
    private TableColumn<Supplyer, String> colSupplyerName;

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

    ObservableList<Supplyer> supplyerObservableList = FXCollections.observableArrayList();

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
        boolean isAdded = SupplyerService.addSuplier(supplyer);

        if (isAdded) {
            clearFields();
        }

    }

    private void clearFields() {
        txtSupplyerID.clear();
        txtSupplyerName.clear();
        txtCompanyName.clear();
        txtContactNumber.clear();
        txtSupplyerEmail.clear();
        txtSupplyerBrand.clear();

    }

    @FXML
    void btnDeleteSupplyerOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) throws SQLException {
        loadTable();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupplyerID.setCellValueFactory(new PropertyValueFactory<>("supplyerID"));
        colSupplyerName.setCellValueFactory(new PropertyValueFactory<>("supplyerName"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colCantactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colSupplyerEmail.setCellValueFactory(new PropertyValueFactory<>("supplyerEmail"));
        colSupplyerBrand.setCellValueFactory(new PropertyValueFactory<>("supplyerBrand"));

        tblSupplyer.setItems(supplyerObservableList);
        try {
            loadTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    SupplyerRepository repository = new SupplyerRepositoryImpl();

    private void loadTable() throws SQLException {
        List<Supplyer> list = repository.getAllSuppliers();
        ObservableList<Supplyer> supplyerObservableList =
                FXCollections.observableArrayList(list);
        tblSupplyer.setItems(supplyerObservableList);
    }
}