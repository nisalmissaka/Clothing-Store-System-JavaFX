package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import dto.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OrderFormController {

    @FXML
    private ComboBox<String> cmbCustomerID;

    @FXML
    private ComboBox<?> cmbItemCode;

    @FXML
    private TableColumn<?, ?> colDesctiption;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<?> tblCart;

    @FXML
    private Label txtAddress;

    @FXML
    private Label txtCustomerName;

    @FXML
    private Label txtDescription;

    @FXML
    private Label txtQTY;

    @FXML
    private Label txtStock;

    @FXML
    private Label txtUnitPrice;


    private void  initialize(URL url, ResourceBundle resourceBundle){

    }

    private void  loadCustomerIds(){
//        CustomerController customerController = new CustomerController();
//
//        ObservableList<String> customerIds = FXCollections.observableArrayList();
//
//        List<Customer> all = customerController.getAll();
//
//        all.forEach(customer -> {
//            customerIds.add(customer.getId());
//        });
//
//        cmbCustomerID.setItems(customerIds);
//
   }

    @FXML
    void btnAddToOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {

    }

}
