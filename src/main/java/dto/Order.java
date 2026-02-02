package dto;

import lombok.*;

@Setter
@Getter
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


