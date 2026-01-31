package repository.impl;

import db.DBConnection;
import dto.Customer;
import repository.CustomerRepository;

import java.sql.*;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public void AddCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, customer.getCustomerID());
        ps.setString(2, customer.getCustomerName());
        ps.setString(3, customer.getAddress());
        ps.setDouble(4, customer.getSalary());
        ps.setString(5, customer.getCity());

        ps.executeUpdate();
    }

    @Override
    public ResultSet getAllCustomer() throws SQLException {
        String sql = "SELECT * FROM customer";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    @Override
    public void DeleteCustomer(String custID) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE CustID = ?");
        preparedStatement.setString(1, custID);
        int rows = preparedStatement.executeUpdate();
        System.out.println("Rows deleted: " + rows);
    }

    @Override
    public ResultSet searchCustomer(String customerId) {
        try {
            String sql = "SELECT * FROM customer WHERE CustID = ?";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customerId);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCustomerById(String customerId) throws SQLException {
        String sql = "SELECT * FROM customer WHERE CustID = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, customerId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Customer(
                    rs.getString("CustID"),
                    rs.getString("CustomerName"),
                    rs.getString("Address"),
                    rs.getDouble("Salary"),
                    rs.getString("City")
            );
        }
        return null;
    }
}

