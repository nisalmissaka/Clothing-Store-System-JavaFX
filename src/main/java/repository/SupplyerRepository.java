package repository;

import dto.Supplyer;

import java.sql.SQLException;
import java.util.List;

public interface SupplyerRepository {
    void AddSupplyer(Supplyer supplyer) throws SQLException;
    List<Supplyer> getAllSupplyers() throws SQLException;

    List<Supplyer> getAllSuppliers() throws SQLException;
}
