package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CartItem;
import dto.Customer;
import dto.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    @FXML
    private JFXButton btnAddtoCart;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDescripstion;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblPrice;

    @FXML
    private TableView<CartItem> tblAddToCart;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtItemCode;

    ItemService itemService = new ItemServiceImpl();


    @FXML
    private JFXTextField txtQuantity;



    @FXML
    void btnAddtoCartOnAction(ActionEvent event) {

    }


CustomerService customerService = new CustomerServiceImpl();
    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {
       Customer customer =  customerService.getCustomer(txtCustomerId.getText());
        lblCustomerName.setText(customer.getCustomerName());
    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {

       Item item =  itemService.searchItem(txtItemCode.getText(),null);
       lblDescripstion.setText(item.getDescription());
       lblPrice.setText(String.valueOf(item.getItemPrice()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        lblDiscount.setText("0.0");
    }

    private double calculateTotal(String unitPrice, String quantity){
        double total = 0.0;
        total = Double.parseDouble(unitPrice) * Integer.parseInt(quantity);
        return total;
    }

    public void clearFields(){
        txtItemCode.setText(null);
        lblDescripstion.setText(null);
        lblPrice.setText(null);
        txtQuantity.setText(null);
        lblDiscount.setText("0.0");
    }

    public void CalculateNetTotal(){

    }


//    ------------Place Order-----------------

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {


    }
}