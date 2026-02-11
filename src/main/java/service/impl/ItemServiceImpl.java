package service.impl;

import dto.CartItem;
import dto.Item;
import dto.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import repository.ItemRepository;
import repository.impl.ItemRepositoryImpl;
import service.ItemService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
    public Item searchItem(String itemCode) {
        String sql = "SELECT * FROM item WHERE ItemCode = ?";

        try {
            ResultSet resultSet = itemRepository.getAllItem();
            // You need to implement proper search logic here
            // For now, search from the cached list
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try {
            for (CartItem cartItem : cartItemObservableList) {

                String sql = "UPDATE item SET Quantity = Quantity - ? WHERE ItemCode = ?";

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateItemQuantity(Connection connection, Order order, ObservableList<CartItem> cartItems) {
        try {
            for (CartItem cartItem : cartItems) {
                String sql = "UPDATE item SET Quantity = Quantity - ? WHERE ItemCode = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, cartItem.getQuantity());
                ps.setString(2, cartItem.getItemCode());
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UpdateItem(Item item) {
        if (item.getItemCode() == null || item.getItemCode().isEmpty()) {
            return false;
        }
        if (item.getItemPrice() < 0) {
            return false;
        }

        try {
            return itemRepository.updateItem(item);
        } catch (SQLException  e) {
            e.printStackTrace();
            return false;
        }
    }
}