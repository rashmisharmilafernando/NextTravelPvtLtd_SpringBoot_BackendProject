package lk.ijse.userserver.service.impl;

import lk.ijse.userserver.dao.CustomerDAO;
import lk.ijse.userserver.dto.CustomDTO;
import lk.ijse.userserver.dto.CustomerDTO;
import lk.ijse.userserver.entity.CustomerEntity;
import lk.ijse.userserver.service.CustomerService;
import lk.ijse.userserver.util.DataConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private  DataConvertor dataConvertor;

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDAO.save(dataConvertor.customerdtoTOcustomerEntity(customerDTO));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (!customerDAO.existsById(customerDTO.getID())){
            throw new RuntimeException("Customer not Exist...!");
        }
        customerDAO.save(dataConvertor.customerdtoTOcustomerEntity(customerDTO));
    }

    @Override
    public void deleteCustomer(String id) {
        customerDAO.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerDAO.findAll().stream().map(customerEntity->dataConvertor.customerEntityTOcustomerDto(customerEntity)).collect(Collectors.toList());
    }

    @Override
    public CustomDTO customerIdGenerate() {
        return new CustomDTO(customerDAO.getLastIndex());
    }

    @Override
    public CustomerDTO searchCustomerId(String customerId) {
        if (!customerDAO.existsById(customerId)){
            throw new RuntimeException("CustomerId is wrong...!");
        }

        CustomerEntity customerEntity = customerDAO.findById(customerId).get();
        return dataConvertor.customerEntityTOcustomerDto(customerEntity);



    }

    @Override
    public CustomDTO getAllCustomerCount() {
        return new CustomDTO(customerDAO.getAllCountCount());
    }
}
