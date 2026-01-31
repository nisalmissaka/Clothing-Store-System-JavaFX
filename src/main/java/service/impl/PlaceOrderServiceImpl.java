package service.impl;

import db.DBConnection;
import dto.CartItem;
import dto.Customer;
import dto.Item;
import dto.Order;
import javafx.collections.ObservableList;
import service.ItemService;
import service.OrderService;
import service.PlaceOrderService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    ItemService itemService = new ItemServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Override
    public Item searchItem(String txtItemCode) {
        String sql = "SELECT ItemCode, Description, ItemSize, ItemPrice, Discount, Quantity FROM item WHERE ItemCode=?";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, txtItemCode.trim());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Item(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("ItemSize"),
                        resultSet.getDouble("ItemPrice"),
                        resultSet.getDouble("Discount"),
                        resultSet.getInt("Quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer searchCustomer(String customerId) {
        return customerService.searchCustomer(customerId);
    }

    @Override
    public boolean addOrder(Connection connection, Order order) {
        return orderService.addOrder(connection, order);
    }

    @Override
    public boolean updateItemQuantity(Connection connection, Order order, ObservableList<CartItem> cartItems) {
        return itemService.updateItemQuantity(connection, order, cartItems);
    }

    @Override
    public boolean placeOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            boolean isOrderSaved = addOrder(connection, order);
            if (!isOrderSaved) {
                connection.rollback();
                return false;
            }

            boolean isDetailsSaved = updateItemQuantity(connection, order, cartItemObservableList);
            if (!isDetailsSaved) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}