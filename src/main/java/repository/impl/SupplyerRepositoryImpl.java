package repository.impl;

import dto.Supplyer;
import repository.SupplyerRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupplyerRepositoryImpl implements SupplyerRepository {
    @Override
    public void AddSupplyer(Supplyer supplyer) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store_db","root","nisal");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO suppliers (Supplier_ID, Supplier_Name, Company_Name, Contact_Number, Supplier_Brand, Supplier_Email) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setObject(1,supplyer.getSupplyerID());
        preparedStatement.setObject(2,supplyer.getSupplyerName());
        preparedStatement.setObject(3,supplyer.getCompanyName());
        preparedStatement.setObject(4,supplyer.getContactNumber());
        preparedStatement.setObject(5,supplyer.getSupplyerBrand());
        preparedStatement.setObject(6,supplyer.getSupplyerEmail());

        preparedStatement.executeUpdate();
    }
}
