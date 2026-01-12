package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private String CustomerID;
    private  String CustomerName;
    private String Address;
    private Double Salary;
    private String City;

    public Customer(String customerID, String customerName, Double salary) {
        this.CustomerID = customerID;
        this.CustomerName = customerName;
        this.Salary = salary;
    }

}
