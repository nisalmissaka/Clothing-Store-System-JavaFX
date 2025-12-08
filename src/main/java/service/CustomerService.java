package service;

import dto.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {


     void AddCustomer(Customer customer) ;

     void DeleteCustomer(Customer customer) throws SQLException;


    boolean DeleteCustomer(String id);

    List<Customer> getAllCustomer( ) throws SQLException;


    Customer getCustomer(String text);


}
