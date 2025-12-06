package controller;

import dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CustomerFormController implements Initializable {


    @FXML
    public TableView<Customer> tblCustomer;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<?> tclCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtSalary;


    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpDateOnAction(ActionEvent event) {

    }

    CustomerService customerService = new CustomerServiceImpl();

    ObservableList <Customer> customerList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustID"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));



        tblCustomer.setItems(customerList);


        try {
            customerList.addAll(customerService.getAllCustomer());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
