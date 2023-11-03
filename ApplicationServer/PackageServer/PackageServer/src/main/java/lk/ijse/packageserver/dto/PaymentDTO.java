package lk.ijse.packageserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String bookingId;
    private String customerId;
    private LocalDate date;
    private double price;
    private String paymentSlip;
}
