package controller;

import dto.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ItemService;
import service.impl.ItemServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {


    private final ItemService itemService = new ItemServiceImpl();
    private final ObservableList<Item> itemList = FXCollections.observableArrayList();

    @FXML
    private TableView<Item> tblItems;

    @FXML
    private TableColumn<Item, String> colItemCode;

    @FXML
    private TableColumn<Item, String> colDesctiption;

    @FXML
    private TableColumn<Item, String> colItemSize;

    @FXML
    private TableColumn<Item, Double> colItemPrice;

    @FXML
    private TableColumn<Item, String> colDiscount;

    @FXML
    private TableColumn<Item, Integer> colQuantity;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemSize;

    @FXML
    private TextField txtItemPrice;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtQuantity;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        try {

            Item newItem = new Item(
                    txtItemCode.getText(),
                    txtDescription.getText(),
                    txtItemSize.getText(),
                    Double.parseDouble(txtItemPrice.getText()),
                    txtDiscount.getText(),
                    Integer.parseInt(txtQuantity.getText())
            );

            itemService.AddItem(newItem);
            loadItemTable();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Item added successfully!");
            alert.showAndWait();


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to add item");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }

    private void loadItemTable() {
        itemList.clear();
        itemList.addAll(itemService.getAll());
        tblItems.setItems(itemList);
//        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDesctiption.setCellValueFactory(new PropertyValueFactory<>("description"));
        colItemSize.setCellValueFactory(new PropertyValueFactory<>("itemSize"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        loadItemTable();
    }

    public void btnReloadOnAction(ActionEvent event) {

    }

    public void btnUpdateOnAction(ActionEvent event) {

    }

    public void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = itemService.DeleteById(txtItemCode.getText());

        if (isDeleted) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Item Deleted Successfully");
            alert.showAndWait();
            loadItemTable();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Delete Failed");
            alert.setContentText("Item not found or SQL error.");
            alert.showAndWait();
        }
    }


    public void btnSearchOnAction(ActionEvent event) {

    }

    public boolean DeleteItem(String itemCode) {
        return itemService.DeleteById(itemCode);
    }
}




