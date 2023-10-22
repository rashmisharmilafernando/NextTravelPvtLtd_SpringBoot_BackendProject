package lk.ijse.userserver.service;

import lk.ijse.userserver.dto.CustomDTO;
import lk.ijse.userserver.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(String id);

    List<CustomerDTO> getAllCustomer();

    CustomDTO customerIdGenerate();

    CustomerDTO searchCustomerId(String customerId);

    CustomDTO getAllCustomerCount();
}
