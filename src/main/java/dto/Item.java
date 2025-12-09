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
    private String discount;
    private int quantity;
}
