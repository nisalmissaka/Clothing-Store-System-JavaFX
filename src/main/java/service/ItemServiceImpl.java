package service;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemServiceImpl implements ItemService{

   private final ItemRepository itemRepository = new ItemRepositoryImpl();



    @Override
        public ObservableList<Item> getAll() {
            ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

        try {
               ResultSet resultSet = itemRepository.getAllItem();

              while (resultSet.next()) {
                  Item item = new Item(
                          resultSet.getString("itemCode"),
                          resultSet.getString("description"),
                          resultSet.getString("itemSize"),
                          resultSet.getDouble("itemPrice"),
                          resultSet.getString("discount"),
                          resultSet.getInt("quantity")
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

    @Override
    public void AddItem(Item newitem) {
        try {
            itemRepository.AddItem(newitem);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
