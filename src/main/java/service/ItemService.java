package service;

import dto.CartItem;
import dto.Item;
import dto.Order;
import javafx.collections.ObservableList;

import java.sql.Connection;

public interface ItemService {
    ObservableList<Item> getAll();
    Item searchItem(String text);
    void AddItem(Item newitem);
    boolean DeleteById(String itemCode);
    boolean updateItemQuantity(ObservableList<CartItem> cartItemObservableList);
    boolean updateItemQuantity(Connection connection, Order order, ObservableList<CartItem> cartItems);
}
