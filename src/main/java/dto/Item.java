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

    public Item(String text, String text1, String text2, double itemPrice, String text3, int quantity) {

    }
}
