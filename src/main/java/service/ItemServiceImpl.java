package service;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemService{

    ItemRepository itemRepository = new ItemRepositoryImpl();

        @Override
        public ObservableList<Item> getAll() {
            ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
            String SQL = "SELECT * FROM item";
            try {
               Connection connection = DBConnection.getInstance().getConnection();
              PreparedStatement psTm = connection.prepareStatement(SQL);
               ResultSet resultSet = ItemRepository.getAll();

              while (resultSet.next()) {
                  Item item = new Item(
                          resultSet.getString("Description"),
                          resultSet.getString("Discount"),
                          resultSet.getDouble("ItemPrice"),
                          resultSet.getString("ItemSize"),
                          resultSet.getString("ItemCode"),
                          resultSet.getInt("Quantity")
                  );
                  itemObservableList.add(item);
              }
                return itemObservableList;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public Item searchItem(String text, JFXTextField txtItemCode) {
        return null;
    }
}
