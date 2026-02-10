package controller;

import db.DBConnection;
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
import service.impl.CustomerServiceImpl;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class CustomerFormController implements Initializable {


    @FXML
    public TableView<Customer> tblCustomer;
    public ObservableList<String> getCustomerIds;


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
    CustomerService customerService=new CustomerServiceImpl();

    @FXML
    void btnAddOnAction(ActionEvent event) {

        Customer customer = new Customer(
                txtCustomerID.getText(),
                txtCustomerName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()),
                txtCity.getText()
        );
        customerService.AddCustomer(customer);

    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String id = txtCustomerID.getText();
        boolean isDeleted = customerService.DeleteCustomer(id);

        if(isDeleted) {
            System.out.println("Customer Delete Successfully");
        } else {
            System.out.println("Customer Not Found!");
        }

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpDateOnAction(ActionEvent event) {
        Customer customer = new Customer(
                txtCustomerID.getText(),
                txtCustomerName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()),
                txtCity.getText()
        );
        customerService.UpdateCustomer(customer);

    }



    ObservableList <Customer> customerList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
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

    public static List<Customer> getAll() {
        return null;

    }

    public Customer searchCustomer(String customerId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM customer WHERE CustID = ?"
            );
            preparedStatement.setString(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5)
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

