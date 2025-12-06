package service;

import dto.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository = new CustomerRepositoryImpl();


    @Override
    public List<Customer> getAllCustomer( ) {

        List<Customer> list = new ArrayList<>();

        try {
         ResultSet rs = customerRepository.getAllCustomer();
            Customer customer1 = null;
            while (rs.next()) {

                customer1 = new Customer(
                        rs.getString("CustID") ,
                        rs.getString("CustomerName") ,
                        rs.getString("Address") ,
                        rs.getDouble("Salary"),
                        rs.getString("City")
                );
            }

            list.add(customer1);

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


        return list;
    }

    @Override
    public Customer getCustomer(String text) {
        return null;
    }
}

