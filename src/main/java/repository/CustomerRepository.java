package repository;

import dto.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {
    void AddCustomer(Customer customer) throws SQLException;
    ResultSet getAllCustomer() throws SQLException;
    void DeleteCustomer(String custID) throws SQLException;
    ResultSet searchCustomer(String customerId);
    Customer getCustomerById(String customerId) throws SQLException;
}
