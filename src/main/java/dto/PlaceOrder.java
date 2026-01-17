package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlaceOrder {
    private String itemCode;
    private String description;
    private String quantity;
    private double unitPrice;
    private String discount;
    private String total;

}
