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
    private String hotelRate;
    private String hotelCategory;
    private String hotelLocation;
    private String hotelCoordinates;
    private String hotelEmail;
    private String hotelNumber1;
    private String hotelNumber2;
    private  String PetsAllowed;
    private  double HotelFee;
    private String CancellationCriteria;
    private String HotelImage;

}
