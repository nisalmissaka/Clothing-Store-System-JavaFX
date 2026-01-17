package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    private String itemCode;
    private String description;
    private String itemSize;
    private double itemPrice;
    private double discount;
    private int quantity;

    public Item(String itemCode, String description, double itemPrice, double discount) {
        this.itemCode = itemCode;
        this.description = description;
        this.itemPrice = itemPrice;
        this.discount = discount;
    }

    public Item(String txtItemCode, String description, double itemprice, double discount, int quantity) {

    }
}

