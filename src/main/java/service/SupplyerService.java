package service;

import dto.Supplyer;

import java.net.URL;
import java.util.ResourceBundle;

public interface SupplyerService {
    void initialize(URL url, ResourceBundle resourceBundle);

    void AddSupplyer(Supplyer supplyer);

}
