package service.impl;

import db.DBConnection;
import dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    }

    @Override
    public boolean DeleteCustomer(String id) {
        try {
            customerRepository.DeleteCustomer(id);
        } catch (SQLException e)  {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public ObservableList<Customer> getAllCustomer() throws SQLException {

        ObservableList<Customer> list = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer";

        Connection con = DBConnection.getInstance().getConnection();

        ResultSet rs = con.prepareStatement(sql).executeQuery();

        while (rs.next()) {
            Customer c = new Customer(
                    rs.getString("custID"),
                    rs.getString("customerName"),
                    rs.getString("address"),
                    rs.getDouble("salary"),
                    rs.getString("city")
            );

            list.add(c);
        }

        return list;
    }

    @Override
    public Customer getCustomer(String customerId) {
        return null;
    }

}
