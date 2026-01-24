package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String itemCode;
    private String description;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double total;
}


