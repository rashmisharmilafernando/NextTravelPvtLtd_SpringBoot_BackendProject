package lk.ijse.packageserver.dto;

import lk.ijse.packageserver.enetity.PackageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDTO {
    private String bookingId;
    private String startDate;
    private String endDate;
    private String nightCount;
    private String dayCount;
    private String adultsCount;
    private String childrenCount;
    private double fullAmount;
    private String paymentSlip;

    public BookingDTO(String bookingId, String startDate, String endDate, String nightCount, String dayCount, String adultsCount, String childrenCount, double fullAmount) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nightCount = nightCount;
        this.dayCount = dayCount;
        this.adultsCount = adultsCount;
        this.childrenCount = childrenCount;
        this.fullAmount = fullAmount;
    }
}
