package service;

import dto.CartItem;
import dto.Order;

import java.sql.SQLException;
import java.util.List;

public interface PlaceOrderService {

    boolean placeOrder(Order order, List<CartItem> cartItems) throws SQLException;
}



