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

    private String itemCode;
    private String description;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double total;
}

