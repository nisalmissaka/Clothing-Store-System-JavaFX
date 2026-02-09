package controller;

import dto.CartItem;
import dto.Customer;
import dto.Item;
import dto.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.PlaceOrderService;
import service.impl.PlaceOrderServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {


    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;
    @FXML
    public TextField txtCustomerID;
    @FXML
    private TextField txtOrderID;
    @FXML
    private TextField txtQuantity;
    @FXML
    private TextField txtSellerID;
    @FXML
    private TextField txtItemCode;
    @FXML
    private Label lblCustomerName;
    @FXML
    private Label lblsalary;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblUnitPrice;
    @FXML
    private Label lblDiscount;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblNetTotal;

    @FXML
    private TableView<CartItem> tblAddToCart;

    ObservableList<CartItem> cartItemsObservableList = FXCollections.observableArrayList();
    PlaceOrderService placeOrderService = new PlaceOrderServiceImpl();


    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

        double total = calculateTotal(
                lblUnitPrice.getText(),
                txtQuantity.getText(),
                lblDiscount.getText()
        );

        CartItem cartItem = new CartItem(
                txtItemCode.getText(),
                lblDescription.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(lblUnitPrice.getText()),
                Double.parseDouble(lblDiscount.getText()),
                total
        );
        cartItemsObservableList.add(cartItem);
        tblAddToCart.setItems(cartItemsObservableList);

        lblTotal.setText(String.valueOf(total));
        calculateNetTotal();

    }
    private double calculateTotal(String unitPriceText, String qtyText, String discountText) {
        double unitPrice = Double.parseDouble(unitPriceText);
        int qty = Integer.parseInt(qtyText);
        double discount = Double.parseDouble(discountText);

        return (unitPrice * qty) - discount;
    }


    private void calculateNetTotal() {
        double netTotal = 0;
        for (CartItem item : cartItemsObservableList) {
            netTotal += item.getTotal();
        }
        lblNetTotal.setText(String.valueOf(netTotal));
    }


    private void clearFields() {
        txtItemCode.clear();
        txtItemCode.requestFocus();
        txtQuantity.setText("");
        lblDescription.setText("");
        lblUnitPrice.setText("");
        lblDiscount.setText("0.0");
    }

    @FXML
    void txtCustomerIDOnAction(ActionEvent event) {
        String customerId = txtCustomerID.getText();
        Customer customer = placeOrderService.searchCustomer(customerId);

        if (customer != null) {
            lblCustomerName.setText(customer.getCustomerName());
            lblsalary.setText(String.valueOf(customer.getSalary()));
        }else {
            new Alert(Alert.AlertType.WARNING,"Customer Not Found").show();
            txtCustomerID.clear();
            lblCustomerName.setText("");
            lblsalary.setText("");
        }

    }
    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        try {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = LocalDateTime.now().format(dtf);


            Order order = new Order(
                    txtOrderID.getText(),
                    txtSellerID.getText(),
                    Double.parseDouble(lblTotal.getText()),
                    "Pending",
                    currentDateTime
            );


            boolean isPlaced = placeOrderService.placeOrder(order, cartItemsObservableList);

            if (isPlaced) {
                new Alert(Alert.AlertType.INFORMATION, "Order Placed Successfully").show();
                cartItemsObservableList.clear();
                lblTotal.setText("0.0");
            } else {
                new Alert(Alert.AlertType.WARNING, "Order Placement Failed!").show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Database Error: " + e.getMessage()).show();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Amount Format!").show();
        }
    }

    public void txtItemCodeOnAction(ActionEvent event) {
        Item item = placeOrderService.searchItem(txtItemCode.getText().trim());

        if (item != null) {
           lblUnitPrice.setText(String.valueOf(item.getItemPrice()));
            lblDiscount.setText(String.valueOf(item.getDiscount()));
            lblDescription.setText(String.valueOf(item.getDescription()));
        } else {
            new Alert(Alert.AlertType.WARNING, "Item Not Found").show();
            clearFields();
        }

    }
    @FXML
    void txtQuantityOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));

    }
}