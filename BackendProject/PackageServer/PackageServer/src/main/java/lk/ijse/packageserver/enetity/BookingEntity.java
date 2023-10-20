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
public class BookingEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;
    @Column(nullable = false)
    private String packageId;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String endDate;
    @Column(nullable = false)
    private String nightCount;
    @Column(nullable = false)
    private String dayCount;
    @Column(nullable = false)
    private String adultsCount;
    @Column(nullable = false)
    private String childrenCount;
    @Column(nullable = false)
    private double fullAmount;
    @Column(nullable = false)
    private String paymentSlip;

}
