package repository.impl;

import dto.Supplyer;
import repository.SupplyerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SupplyerRepositoryImpl implements SupplyerRepository {
    @Override
    public void AddSupplyer(Supplyer supplyer) throws SQLException {
        List<Supplyer> list = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store_db", "root", "nisal");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO suppliers (Supplier_ID, Supplier_Name, Company_Name, Contact_Number, Supplier_Brand, Supplier_Email) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setObject(1, supplyer.getSupplyerID());
        preparedStatement.setObject(2, supplyer.getSupplyerName());
        preparedStatement.setObject(3, supplyer.getCompanyName());
        preparedStatement.setObject(4, supplyer.getContactNumber());
        preparedStatement.setObject(5, supplyer.getSupplyerBrand());
        preparedStatement.setObject(6, supplyer.getSupplyerEmail());

         preparedStatement.executeUpdate();

//        while (resultSet.next()) {
//            list.add(new Supplyer(
//                    resultSet.getString("Supplier_ID"),
//                    resultSet.getString("Supplier_ID"),
//                    resultSet.getString("Supplier_ID"),
//                    resultSet.getString("Supplier_ID"),
//                    resultSet.getString("Supplier_ID")
//            ));



    }

    @Override
    public List<Supplyer> getAllSupplyers() throws SQLException {
        return List.of();
    }
}
