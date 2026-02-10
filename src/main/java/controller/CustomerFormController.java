package controller;

import db.DBConnection;
import dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private TableView<Customer> tblCustomer;

    @FXML
    private TableColumn<Customer, String> colAddress;

    @FXML
    private TableColumn<Customer, String> colCity;

    @FXML
    private TableColumn<Customer, String> colCustomerID;

    @FXML
    private TableColumn<Customer, String> colCustomerName;

    @FXML
    private TableColumn<Customer, Double> colSalary;

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

    private CustomerService customerService = new CustomerServiceImpl();
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));

        tblCustomer.setItems(customerList);
        loadTable();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtCustomerID.setText(newSelection.getCustomerID());
                txtCustomerName.setText(newSelection.getCustomerName());
                txtAddress.setText(newSelection.getAddress());
                txtSalary.setText(String.valueOf(newSelection.getSalary()));
                txtCity.setText(newSelection.getCity());
            }
        });
    }

    private void loadTable() {
        customerList.clear();
        try {
            List<Customer> allCustomers = customerService.getAllCustomer();
            if (allCustomers != null) {
                customerList.addAll(allCustomers);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error loading data: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        try {
            Customer customer = new Customer(
                    txtCustomerID.getText(),
                    txtCustomerName.getText(),
                    txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText()),
                    txtCity.getText()
            );
            boolean isAdded = customerService.AddCustomer(customer);
            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Added!").show();
                loadTable();
                clearFields();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Salary!").show();
        }
    }

    @FXML
    void btnUpDateOnAction(ActionEvent event) {
        try {
            Customer customer = new Customer(
                    txtCustomerID.getText(),
                    txtCustomerName.getText(),
                    txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText()),
                    txtCity.getText()
            );

            boolean isUpdated = customerService.UpdateCustomer(customer);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Updated Successfully!").show();
                loadTable();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Update Failed!").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Input!").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtCustomerID.getText();
        if (id.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please select a customer!").show();
            return;
        }

        boolean isDeleted = customerService.DeleteCustomer(id);
        if (isDeleted) {
            new Alert(Alert.AlertType.INFORMATION, "Deleted!").show();
            loadTable();
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Found!").show();
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadTable();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        Customer customer = searchCustomer(txtCustomerID.getText());
        if (customer != null) {
            txtCustomerName.setText(customer.getCustomerName());
            txtAddress.setText(customer.getAddress());
            txtSalary.setText(String.valueOf(customer.getSalary()));
            txtCity.setText(customer.getCity());
        } else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Found!").show();
        }
    }

    private void clearFields() {
        txtCustomerID.clear();
        txtCustomerName.clear();
        txtAddress.clear();
        txtSalary.clear();
        txtCity.clear();
    }


    public Customer searchCustomer(String customerId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE CustID = ?");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}