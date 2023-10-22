package lk.ijse.hotelserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelDTO {
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private String coordinates;
    private String starRate;
    private String packageCategory;
    private String hotelContactNumberOne;
    private String hotelContactNumberTwo;
    private  boolean petsAllowedOrNot;
    private  String cancelCriteria;
    private  double hotelFee;
    private String email;
    private String image;

}
