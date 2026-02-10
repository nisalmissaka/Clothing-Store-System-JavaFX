package service;

import dto.Customer;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CustomerService {
    boolean AddCustomer(Customer customer);
    void DeleteCustomer(Customer customer) throws SQLException;
    boolean DeleteCustomer(String id);
    ObservableList<Customer> getAllCustomer() throws SQLException;
    Customer getCustomer(String customerId);
    Customer searchCustomer(String customerId);

    boolean UpdateCustomer(Customer customer);

}
