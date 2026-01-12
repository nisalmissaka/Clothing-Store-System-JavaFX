package service.impl;

import db.DBConnection;
import dto.CartItem;
import dto.Customer;
import dto.Item;
import dto.Order;
import javafx.collections.ObservableList;
import service.CustomerService;
import service.ItemService;
import service.PlaceOrderService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;


public class PlaceOrderServiceImpl implements PlaceOrderService {

    ItemService itemService = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();


    @Override
    public boolean placeOrder(Order order, List<CartItem> cartItems) throws SQLException {
        return false;
    }

    @Override
    public boolean placeOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        System.out.println("Order Placed");
        System.out.println(order);

        for (CartItem item : cartItemObservableList) {
            System.out.println(item);
        }
        return true;
    }

    @Override
    public Item searchItem(String txtItemCode) {
        return null;
    }

    @Override
    public Customer searchCustomer(String customerId) {
        String sql = "SELECT CustomerName, Salary FROM customer WHERE CustID=?";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Customer(
                        customerId,
                        resultSet.getString("CustomerName"),
                        resultSet.getDouble("Salary")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

