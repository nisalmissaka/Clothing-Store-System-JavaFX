package service.impl;

import dto.CartItem;
import dto.Order;
import service.PlaceOrderService;

import java.sql.SQLException;
import java.util.List;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Override
    public boolean placeOrder(Order order, List<CartItem> cartItems) throws SQLException {

        // TEMP LOGIC (DB insert later)
        System.out.println("Order Placed");
        System.out.println(order);

        for (CartItem item : cartItems) {
            System.out.println(item);
        }

        return true;
    }
}

