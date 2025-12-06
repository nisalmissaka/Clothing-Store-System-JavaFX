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

    private String Description;
    private String Discount;
    private String ItemCode;
    private double ItemPrice;
    private String ItemSize;
    private int Quantity;


    public Item(String description, String discount, double itemPrice, String itemSize, String itemCode, int quantity) {

    }
}
