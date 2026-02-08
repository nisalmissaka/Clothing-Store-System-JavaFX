package service.impl;

import dto.Order;
import service.OrderService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    @Override
    public boolean addOrder(Connection connection, Order order) {
        String sql = "INSERT INTO orders (order_id, seller_id, total_amount, status, order_date) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, order.getOrderID());
            ps.setString(2, order.getSellerId());
            ps.setDouble(3, order.getTotalAmount());
            ps.setString(4, order.getStatus());
            ps.setString(5, order.getOrderDate());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
