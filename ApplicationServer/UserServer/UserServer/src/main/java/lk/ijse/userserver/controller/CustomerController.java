package lk.ijse.userserver.controller;


import lk.ijse.userserver.dto.CustomDTO;
import lk.ijse.userserver.dto.CustomerDTO;
import lk.ijse.userserver.dto.CustomerResponese;
import lk.ijse.userserver.service.CustomerService;
import lk.ijse.userserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
//--------------------save Customer------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String nic,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam MultipartFile profilePic) {
        if (profilePic.isEmpty()) {
            throw new RuntimeException("profile Picture is empty...!");
        }
        try {
            customerService.saveCustomer(new CustomerDTO(
                    id,
                    name,
                    email,
                    address,
                    nic,
                    username,
                    password,
                    Base64.getEncoder().encodeToString(profilePic.getBytes())));
            return new ResponseUtil("OK", "Successfully save customer..!", null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //--------------------update customer------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public ResponseUtil updateCustomer(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String nic,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam MultipartFile profilePic) {
        if (profilePic.isEmpty()) {
            throw new RuntimeException("profile Picture is empty...!");
        }
        try {
            CustomerDTO customerDTO = new CustomerDTO(id, name, email, address, nic, username, password, Base64.getEncoder().encodeToString(profilePic.getBytes()));
            customerService.updateCustomer(customerDTO);
            return new ResponseUtil("ok", "Successfully save Customer", null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------Delete customer---------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/id")
    public ResponseUtil deleteCustomer(String id){
         customerService.deleteCustomer(id);
        return new ResponseUtil("OK","Successfully Deleted..!"+id,null);
    }

    //----------------load data to table----------------------


    @GetMapping(path = "/loadCustomer")
    public ResponseEntity<List<CustomerResponese>>getAllCustomer(){
        List<CustomerResponese> customerResponese=customerService.getAllCustomer().stream().map(e ->
             new CustomerResponese(
                     e.getID(),
                     e.getName(),
                     e.getEmail(),
                     e.getAddress(),
                     e.getNIC(),
                     e.getUsername(),
                     e.getPassword()
             )
        ).toList();
        return new ResponseEntity<>(customerResponese,HttpStatus.OK);
    }

    //---------Auto generate customer id-------------------

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/registerUserIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate(){
        return customerService.customerIdGenerate();
    }
    //----------------------search customer------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCustomer",params = {"customerId"})
    public CustomerDTO searchCustomerId(String customerId){
        return customerService.searchCustomerId(customerId);
    }

    //------------------Customer Count---------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/customerCount")
    public @ResponseBody CustomDTO getSumCustomer(){
        return customerService.getAllCustomerCount();
    }
}
