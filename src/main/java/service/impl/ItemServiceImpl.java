package service.impl;

import com.jfoenix.controls.JFXTextField;
import dto.CartItem;
import dto.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.ItemRepository;
import repository.impl.ItemRepositoryImpl;
import service.ItemService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemService {

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
                        resultSet.getDouble("discount"),
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

    @Override
    public boolean DeleteById(String itemCode) {
        try {
            return itemRepository.DeleteItemCode(itemCode);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateItemQuantity(ObservableList<CartItem> cartItemObservableList) {
        return false;
    }
}
