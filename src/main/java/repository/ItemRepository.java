package repository;

import dto.Customer;
import dto.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {
    void AddItem(Item item) throws SQLException;
    ResultSet getAllItem() throws SQLException;
    Customer getCustomer(String text);
    boolean DeleteItemCode(String itemCode) throws SQLException;
    boolean updateItem(Item item) throws SQLException;

}

