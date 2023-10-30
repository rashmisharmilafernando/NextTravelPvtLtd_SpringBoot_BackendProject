package lk.ijse.packageserver.enetity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Booking")
public class BookingEntity implements SuperEntity{
    @Id
    private String bookingId;
    private String startDate;
    private String endDate;
    private String nightCount;
    private String dayCount;
    private String adultsCount;
    private String childrenCount;
    private double fullAmount;
    private String paymentSlip;

    @ManyToOne
    @JoinColumn(name = "packageId",referencedColumnName = "packageId")
    private PackageEntity packageId;

}
