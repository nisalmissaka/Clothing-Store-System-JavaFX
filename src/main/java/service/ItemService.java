package service;

import com.jfoenix.controls.JFXTextField;
import dto.Item;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;

public interface ItemService {

    ObservableList<Item> getAll();

    Item searchItem(String text, JFXTextField txtItemCode);

    void AddItem(Item newitem);



}
