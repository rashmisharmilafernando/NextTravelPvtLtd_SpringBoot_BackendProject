package lk.ijse.packageserver.server;

import lk.ijse.packageserver.dto.PaymentDTO;
import lk.ijse.packageserver.dto.ReportDTO;

import java.util.ArrayList;

public interface PaymentService {
    void savePayment(PaymentDTO paymentDTO);

    ArrayList<ReportDTO> dailyIncome();

    ArrayList<ReportDTO> monthlyIncome();

    ArrayList<ReportDTO> AnnuallyIncome();
}
