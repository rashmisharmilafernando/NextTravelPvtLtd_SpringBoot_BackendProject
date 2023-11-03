package lk.ijse.packageserver.enetity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentEntity {
    @Id
    private String bookingId;
    private String customerId;
    private LocalDate date;
    private double price;
    @Column(columnDefinition = "LONGTEXT")
    private String paymentSlip;
}
