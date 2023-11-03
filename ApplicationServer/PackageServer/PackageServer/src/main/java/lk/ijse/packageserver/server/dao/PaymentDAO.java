package lk.ijse.packageserver.server.dao;

import lk.ijse.packageserver.dto.ReportDTO;
import lk.ijse.packageserver.enetity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PaymentDAO extends JpaRepository<PaymentEntity,String> {

    @Query(value = "SELECT payment.date,count(payment.bookingId),sum(payment.price) FROM Payment GROUP BY date", nativeQuery = true)
    ArrayList<ReportDTO> dailyIncome();

    @Query(value = "SELECT (MONTHNAME(date )) ,count(payment.bookingId),sum(payment.price)FROM  Payment  GROUP BY extract(MONTH FROM(date))", nativeQuery = true)
    ArrayList<ReportDTO> monthlyIncome();

    @Query(value = "SELECT (YEAR(date )) ,count(payment.bookingId),sum(payment.price)FROM Payment GROUP BY extract(YEAR FROM(date))", nativeQuery = true)
    ArrayList<ReportDTO> annuallyIncome();
}
