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
    private byte[] HotelImage;

    public HotelRespone(String hotelId, String hotelName, String hotelRate, String hotelCategory, String hotelLocation, String hotelCoordinates, String hotelEmail, String hotelNumber1, String hotelNumber2, String petsAllowed, double hotelFee, String cancellationCriteria) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelRate = hotelRate;
        this.hotelCategory = hotelCategory;
        this.hotelLocation = hotelLocation;
        this.hotelCoordinates = hotelCoordinates;
        this.hotelEmail = hotelEmail;
        this.hotelNumber1 = hotelNumber1;
        this.hotelNumber2 = hotelNumber2;
        PetsAllowed = petsAllowed;
        HotelFee = hotelFee;
        CancellationCriteria = cancellationCriteria;
    }
}
