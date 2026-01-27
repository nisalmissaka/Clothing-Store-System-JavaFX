package service.impl;

import dto.Supplyer;
import repository.SupplyerRepository;
import repository.impl.SupplyerRepositoryImpl;
import service.SupplyerService;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplyerServiceImpl implements SupplyerService {
    SupplyerRepository repository = new SupplyerRepositoryImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void AddSupplyer(Supplyer supplyer) {
        repository.AddSupplyer(supplyer);

    }
}
