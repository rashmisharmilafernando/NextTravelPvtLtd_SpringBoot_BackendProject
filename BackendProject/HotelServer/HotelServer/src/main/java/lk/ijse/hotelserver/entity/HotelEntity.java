package lk.ijse.hotelserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String hotelId;
    @Column(nullable = false)
    private String hotelLocation;
    @Column(nullable = false)
    private String hotelName;
    @Column(nullable = false)
    private String coordinates;
    @Column(nullable = false)
    private String roomType;
    @Column(nullable = false)
    private String starRate;
    @Column(nullable = false)
    private String packageCategory;
    @Column(nullable = false)
    private String hotelContactNumber;
    @Column(nullable = false)
    private  boolean petsAllowedOrNot;
    @Column(nullable = false)
    private  String cancelCriteria;
    @Column(nullable = false)
    private  String remarks;
    @Column(nullable = false)
    private  double hotelFee;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String image;
}
