package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private String CustomerID;
    private String ItemCode;
    private double UnitPrice;
    private String Description;
    private String Quantity;
    private String Address;
}
