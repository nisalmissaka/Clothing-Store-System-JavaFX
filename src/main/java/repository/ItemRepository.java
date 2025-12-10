package repository;

import db.DBConnection;
import dto.Customer;
import dto.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ItemRepository {


    void AddItem(Item item) throws SQLException;

   ResultSet  getAllItem() throws SQLException;

    Customer getCustomer(String text);


   boolean DeleteItemCode(String itemCode) throws SQLException;

}

