package service;

import dto.Supplyer;

import java.net.URL;
import java.util.ResourceBundle;

public interface SupplyerService {
    static boolean AddSuplier(Supplyer supplyer) {

        return false;
    }

    static boolean addSuplier(Supplyer supplyer) {

        return false;
    }

    void initialize(URL url, ResourceBundle resourceBundle);


    Supplyer AddSupplyer();

    void AddSupplyer(Supplyer supplyer);
}
