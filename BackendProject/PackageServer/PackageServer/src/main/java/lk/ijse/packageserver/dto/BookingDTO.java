package lk.ijse.packageserver.dto;

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
    private String packageId;
    private String startDate;
    private String endDate;
    private String nightCount;
    private String dayCount;
    private String adultsCount;
    private String childrenCount;
    private double fullAmount;
    private String paymentSlip;

}
