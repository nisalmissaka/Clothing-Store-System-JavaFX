package controller;

import dto.CartItem;
import dto.Customer;
import dto.Item;
import dto.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import service.PlaceOrderService;
import service.impl.PlaceOrderServiceImpl;

import java.sql.SQLException;

public class PlaceOrderFromController {

    @FXML
    public TextField txtCustomerID;

    @FXML
    private TextField txtItemCode;
    @FXML
    private TextField txtQuantity;
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
        clearFields();
    }

    // ================= CALCULATE TOTAL =================
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
        txtQuantity.clear();
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
            Order order = new Order(
                    txtItemCode.getText(),
                    lblDescription.getText(),
                    Integer.parseInt(txtQuantity.getText()),
                    Double.parseDouble(lblUnitPrice.getText()),
                    Double.parseDouble(lblDiscount.getText()),
                    Double.parseDouble(lblNetTotal.getText())
            );

            boolean isPlaced = placeOrderService.placeOrder(order, cartItemsObservableList);

            if (isPlaced) {
                new Alert(Alert.AlertType.INFORMATION, "Order Placed Successfully").show();
                cartItemsObservableList.clear();
                lblNetTotal.setText("0.0");
            }

        } catch (SQLException | NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Data").show();
        }


    }

    public void txtItemCodeOnAction(ActionEvent event) {
        Item item = placeOrderService.searchItem(txtItemCode.getText());

        if (item != null) {
            lblDescription.setText(item.getDescription());
            lblUnitPrice.setText(String.valueOf(item.getItemPrice()));
            lblDiscount.setText(String.valueOf(item.getDiscount()));
            txtQuantity.requestFocus();
        } else {
            new Alert(Alert.AlertType.WARNING, "Item Not Found").show();
            clearFields();
        }

    }
}