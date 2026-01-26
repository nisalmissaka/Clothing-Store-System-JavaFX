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
    private  String sup_id;
    private  String sup_name;
    private  String phoneNumber;
    private String address;
}
