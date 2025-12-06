package service;

import dto.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {



    List<Customer> getAllCustomer( ) throws SQLException;


    Customer getCustomer(String text);
}
