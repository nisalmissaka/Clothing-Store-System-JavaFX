package service;

import com.jfoenix.controls.JFXTextField;
import dto.CartItem;
import dto.Item;
import javafx.collections.ObservableList;

public interface ItemService {

    ObservableList<Item> getAll();

    Item searchItem(String text, JFXTextField txtItemCode);

    void AddItem(Item newitem);


    boolean DeleteById(String itemCode);

    boolean updateItemQuantity(ObservableList<CartItem> cartItemObservableList);

}
