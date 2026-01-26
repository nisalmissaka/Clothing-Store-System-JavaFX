package service;

import dto.CartItem;
import dto.Customer;
import dto.Item;
import dto.Order;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PlaceOrderService {

     static boolean updateItemQuantity(Connection connection, Order order, ObservableList<CartItem> cartItemObservableList) {
         return false;
    }

    static boolean addOrder(Connection connection, Order order) {
         return false;
    }

    boolean placeOrder(Order order, List<CartItem> cartItems) throws SQLException;

    boolean placeOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException;

    Item searchItem(String txtItemCode);

    Customer searchCustomer(String customerId);

    void plceOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException;
}



