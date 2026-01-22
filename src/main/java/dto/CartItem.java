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
    private int Quantity;
    private double ItemPrice;
    private double Discount;
    private double Total;
}

