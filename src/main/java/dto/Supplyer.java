package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplyer {
    private String supplyerID;
    private String supplyerName;
    private String companyName;
    private String contactNumber;
    private String supplyerEmail;
    private String supplyerBrand;

}
