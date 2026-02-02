package service;

import dto.Supplyer;

import java.net.URL;
import java.util.ResourceBundle;

public interface SupplyerService {


    void AddSupplyer(Supplyer supplyer);


    boolean deleteSupplyer(String supplyerID);
}
