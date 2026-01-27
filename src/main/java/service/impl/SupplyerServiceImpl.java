package service.impl;

import dto.Supplyer;
import repository.SupplyerRepository;
import repository.impl.SupplyerRepositoryImpl;
import service.SupplyerService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupplyerServiceImpl implements SupplyerService {
    SupplyerRepository repository = new SupplyerRepositoryImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public Supplyer AddSupplyer() {
        return null;
    }

    @Override
    public void AddSupplyer(Supplyer supplyer) {
        try {
            repository.AddSupplyer(supplyer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}