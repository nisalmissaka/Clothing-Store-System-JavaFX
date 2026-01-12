package service;

import dto.CartItem;
import dto.Customer;
import dto.Item;
import dto.Order;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface PlaceOrderService {

    boolean placeOrder(Order order, List<CartItem> cartItems) throws SQLException;

    boolean placeOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException;

    Item searchItem(String txtItemCode);

    Customer searchCustomer(String customerId);

}



