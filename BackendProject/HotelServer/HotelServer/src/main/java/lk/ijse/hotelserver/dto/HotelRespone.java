package lk.ijse.hotelserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelRespone {
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
    private byte[] image;

    public HotelRespone(String hotelId, String hotelName, String hotelLocation, String coordinates, String starRate, String packageCategory, String hotelContactNumberOne, String hotelContactNumberTwo, boolean petsAllowedOrNot, String cancelCriteria, double hotelFee, String email) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.coordinates = coordinates;
        this.starRate = starRate;
        this.packageCategory = packageCategory;
        this.hotelContactNumberOne = hotelContactNumberOne;
        this.hotelContactNumberTwo = hotelContactNumberTwo;
        this.petsAllowedOrNot = petsAllowedOrNot;
        this.cancelCriteria = cancelCriteria;
        this.hotelFee = hotelFee;
        this.email = email;
    }
}
