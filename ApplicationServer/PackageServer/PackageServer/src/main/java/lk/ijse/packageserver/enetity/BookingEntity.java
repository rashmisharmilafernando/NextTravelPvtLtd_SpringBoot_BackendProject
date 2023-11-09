package lk.ijse.packageserver.enetity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Booking")
public class BookingEntity implements SuperEntity{
    @Id
    private String bookingId;
    private String guideId;
    private String userId;
    private LocalDate currentlyDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private int nightCount;
    private int dayCount;
    private int adultsCount;
    private int childrenCount;

    @ManyToOne
    @JoinColumn(name = "packageId",referencedColumnName = "packageId")
    private PackageEntity packageId;

}
