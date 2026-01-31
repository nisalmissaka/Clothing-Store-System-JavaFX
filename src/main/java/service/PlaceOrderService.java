package service;

import dto.CartItem;
import dto.Customer;
import dto.Item;
import dto.Order;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

public interface PlaceOrderService {
    Item searchItem(String itemCode);
    Customer searchCustomer(String customerId);
    boolean addOrder(Connection connection, Order order);
    boolean updateItemQuantity(Connection connection, Order order, ObservableList<CartItem> cartItems);
    boolean placeOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException;
}




