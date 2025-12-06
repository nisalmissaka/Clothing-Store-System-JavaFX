package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ItemFormController {

    @FXML
    private TableColumn<?, ?> colDesctiption;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colItemSize;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblItemCode;

    @FXML
    private Label lblItemPrice;

    @FXML
    private Label lblItemSize;

    @FXML
    private Label lblQuantity;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtItemPrice;

    @FXML
    private TextField txtItemSize;

    @FXML
    private TextField txtQuantity;



    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    private void loadItemTable() {
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    public TableColumn<?, ?> getColDesctiption() {
        return colDesctiption;
    }

    public void setColDesctiption(TableColumn<?, ?> colDesctiption) {
        this.colDesctiption = colDesctiption;
    }

    public TableColumn<?, ?> getColDiscount() {
        return colDiscount;
    }

    public void setColDiscount(TableColumn<?, ?> colDiscount) {
        this.colDiscount = colDiscount;
    }

    public TableColumn<?, ?> getColItemCode() {
        return colItemCode;
    }

    public void setColItemCode(TableColumn<?, ?> colItemCode) {
        this.colItemCode = colItemCode;
    }

    public TableColumn<?, ?> getColItemPrice() {
        return colItemPrice;
    }

    public void setColItemPrice(TableColumn<?, ?> colItemPrice) {
        this.colItemPrice = colItemPrice;
    }

    public TableColumn<?, ?> getColItemSize() {
        return colItemSize;
    }

    public void setColItemSize(TableColumn<?, ?> colItemSize) {
        this.colItemSize = colItemSize;
    }

    public TableColumn<?, ?> getColQuantity() {
        return colQuantity;
    }

    public void setColQuantity(TableColumn<?, ?> colQuantity) {
        this.colQuantity = colQuantity;
    }

    public Label getLblDescription() {
        return lblDescription;
    }

    public void setLblDescription(Label lblDescription) {
        this.lblDescription = lblDescription;
    }

    public Label getLblDiscount() {
        return lblDiscount;
    }

    public void setLblDiscount(Label lblDiscount) {
        this.lblDiscount = lblDiscount;
    }

    public Label getLblItemCode() {
        return lblItemCode;
    }

    public void setLblItemCode(Label lblItemCode) {
        this.lblItemCode = lblItemCode;
    }

    public Label getLblItemPrice() {
        return lblItemPrice;
    }

    public void setLblItemPrice(Label lblItemPrice) {
        this.lblItemPrice = lblItemPrice;
    }

    public Label getLblItemSize() {
        return lblItemSize;
    }

    public void setLblItemSize(Label lblItemSize) {
        this.lblItemSize = lblItemSize;
    }

    public Label getLblQuantity() {
        return lblQuantity;
    }

    public void setLblQuantity(Label lblQuantity) {
        this.lblQuantity = lblQuantity;
    }

    public TextField getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(TextField txtDescription) {
        this.txtDescription = txtDescription;
    }

    public TextField getTxtDiscount() {
        return txtDiscount;
    }

    public void setTxtDiscount(TextField txtDiscount) {
        this.txtDiscount = txtDiscount;
    }

    public TextField getTxtItemCode() {
        return txtItemCode;
    }

    public void setTxtItemCode(TextField txtItemCode) {
        this.txtItemCode = txtItemCode;
    }

    public TextField getTxtItemPrice() {
        return txtItemPrice;
    }

    public void setTxtItemPrice(TextField txtItemPrice) {
        this.txtItemPrice = txtItemPrice;
    }

    public TextField getTxtItemSize() {
        return txtItemSize;
    }

    public void setTxtItemSize(TextField txtItemSize) {
        this.txtItemSize = txtItemSize;
    }

    public TextField getTxtQuantity() {
        return txtQuantity;
    }

    public void setTxtQuantity(TextField txtQuantity) {
        this.txtQuantity = txtQuantity;
    }
}