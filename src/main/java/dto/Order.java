package dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderID;
    private String sellerId;
    private double totalAmount;
    private String status;
    private String orderDate;

}


