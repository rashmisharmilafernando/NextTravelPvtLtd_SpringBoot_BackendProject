package lk.ijse.hotelserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hotel")
public class HotelEntity {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelRate;
    private String hotelCategory;
    private String hotelLocation;
    private String hotelCoordinates;
    private String hotelEmail;
    private String hotelNumber1;
    private String hotelNumber2;
    private String PetsAllowed;
    private double HotelFee;
    private String CancellationCriteria;
    @Column(columnDefinition = "LONGTEXT")
    private String HotelImage;
}
