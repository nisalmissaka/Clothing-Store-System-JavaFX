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
    private String ItemCode;
    private String Description;
    private String Quantity;
    private double UnitPrice;
    private String Discount;
    private String total;
}
