package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem {
    private String ItemCode;
    private String Description;
    private String ItemSize;
    private int Quantity;
    private double ItemPrice;
    private double Discount;
    private double Total;

    // Overloaded constructor without ItemSize
    public CartItem(String itemCode, String description, int quantity,
                    double itemPrice, double discount, double total) {
        this.ItemCode = itemCode;
        this.Description = description;
        this.Quantity = quantity;
        this.ItemPrice = itemPrice;
        this.Discount = discount;
        this.Total = total;
    }
}

