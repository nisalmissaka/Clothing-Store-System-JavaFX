package repository.impl;

import dto.Supplyer;
import repository.SupplyerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplyerRepositoryImpl implements SupplyerRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store_db", "root", "nisal");
    }

    @Override
    public void AddSupplyer(Supplyer supplyer) throws SQLException {
        String sql = "INSERT INTO suppliers (Supplier_ID, Supplier_Name, Company_Name, Contact_Number, Supplier_Brand, Supplier_Email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setObject(1, supplyer.getSupplyerID());
            preparedStatement.setObject(2, supplyer.getSupplyerName());
            preparedStatement.setObject(3, supplyer.getCompanyName());
            preparedStatement.setObject(4, supplyer.getContactNumber());
            preparedStatement.setObject(5, supplyer.getSupplyerBrand());
            preparedStatement.setObject(6, supplyer.getSupplyerEmail());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Supplyer> getAllSupplyers() throws SQLException {
        return List.of();
    }

    @Override
    public List<Supplyer> getAllSuppliers() throws SQLException {
        List<Supplyer> supplierList = new ArrayList<>();
        String sql = "SELECT * FROM suppliers";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                supplierList.add(new Supplyer(
                        resultSet.getString("Supplier_ID"),
                        resultSet.getString("Supplier_Name"),
                        resultSet.getString("Company_Name"),
                        resultSet.getString("Contact_Number"),
                        resultSet.getString("Supplier_Brand"),
                        resultSet.getString("Supplier_Email")
                ));
            }
        }
        return supplierList;
    }
}
