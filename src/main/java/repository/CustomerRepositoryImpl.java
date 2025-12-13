package repository;


import db.DBConnection;
import dto.Customer;

import java.sql.*;

public class CustomerRepositoryImpl implements CustomerRepository{

    private String rows;


    @Override
    public void AddCustomer(Customer customer) throws SQLException {

        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/clothing_store_db",
                        "root",
                        "nisal"
                );

        String sql = "INSERT INTO customer VALUES (?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setObject(1, customer.getCustID());
        ps.setObject(2, customer.getCustomerName());
        ps.setObject(3, customer.getAddress());
        ps.setObject(4, customer.getSalary());
        ps.setObject(5, customer.getCity());

        ps.executeUpdate();
    }

    @Override
    public ResultSet getAllCustomer( ) throws SQLException {


            String sql = "SELECT * FROM customer";
            Connection connection = null;
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return rs;


    }

    @Override
    public void DeleteCustomer(String custID) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE CustID = ?");
        preparedStatement.setString(1,custID);
        preparedStatement.executeUpdate();
        System.out.println("Row deleted:" + rows);
    }
}

