package repository;

import dto.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface CustomerRepository {

    ResultSet getAllCustomer( ) throws SQLException;



}
