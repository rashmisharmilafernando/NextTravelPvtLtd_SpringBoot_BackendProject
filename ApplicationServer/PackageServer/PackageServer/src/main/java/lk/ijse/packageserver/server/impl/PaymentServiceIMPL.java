package lk.ijse.packageserver.server.impl;

import lk.ijse.packageserver.dto.PaymentDTO;
import lk.ijse.packageserver.dto.ReportDTO;
import lk.ijse.packageserver.server.PackageService;
import lk.ijse.packageserver.server.PaymentService;
import lk.ijse.packageserver.server.dao.PaymentDAO;
import lk.ijse.packageserver.util.DataConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service
public class PaymentServiceIMPL implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;
    @Autowired
    private DataConvertor convertor;


    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if (paymentDAO.existsById(paymentDTO.getBookingId()))
            throw new RuntimeException(paymentDTO.getBookingId()+" Payment is already exists..!!");
       paymentDAO.save(convertor.paymentDtoToPaymentEntity(paymentDTO));

    }

    @Override
    public ArrayList<ReportDTO> dailyIncome() {
        return paymentDAO.dailyIncome();
    }

    @Override
    public ArrayList<ReportDTO> monthlyIncome() {
        return paymentDAO.monthlyIncome();
    }

    @Override
    public ArrayList<ReportDTO> AnnuallyIncome() {
        return paymentDAO.annuallyIncome();
    }
}
