package service.impl;

import dto.Supplyer;
import repository.SupplyerRepository;
import repository.impl.SupplyerRepositoryImpl;
import service.SupplyerService;

import java.sql.SQLException;

public class SupplyerServiceImpl implements SupplyerService {

    SupplyerRepository repository = new SupplyerRepositoryImpl();

    @Override
    public void AddSupplyer(Supplyer supplyer) {
        try {
            repository.AddSupplyer(supplyer);
            System.out.println("Supplier Added Successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}