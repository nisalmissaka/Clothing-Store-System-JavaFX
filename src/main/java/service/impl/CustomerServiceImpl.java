package service.impl;

import db.DBConnection;
import dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.*;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void AddCustomer(Customer customer) {
        try {
            customerRepository.AddCustomer(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void DeleteCustomer(Customer customer) throws SQLException {
        // Implementation if needed
    }

    @Override
    public boolean DeleteCustomer(String id) {
        try {
            customerRepository.DeleteCustomer(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ObservableList<Customer> getAllCustomer() throws SQLException {
        ObservableList<Customer> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer";

        Connection con = DBConnection.getInstance().getConnection();
        ResultSet rs = con.prepareStatement(sql).executeQuery();

        while (rs.next()) {
            Customer c = new Customer(
                    rs.getString("CustID"),
                    rs.getString("CustomerName"),
                    rs.getString("Address"),
                    rs.getDouble("Salary"),
                    rs.getString("City")
            );
            list.add(c);
        }
        return list;
    }

    @Override
    public Customer getCustomer(String customerId) {
        try {
            return customerRepository.getCustomerById(customerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer searchCustomer(String customerId) {
        try {
            ResultSet rs = customerRepository.searchCustomer(customerId);
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}