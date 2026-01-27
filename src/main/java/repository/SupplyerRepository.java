package repository;

import dto.Supplyer;

import java.sql.SQLException;

public interface SupplyerRepository {
    void AddSupplyer(Supplyer supplyer) throws SQLException;

}
