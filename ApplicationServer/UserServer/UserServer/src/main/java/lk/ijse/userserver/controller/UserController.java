package lk.ijse.userserver.controller;

import lk.ijse.userserver.dto.UsersDTO;
import lk.ijse.userserver.service.Userservice;
import lk.ijse.userserver.util.RoleType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    public final Userservice userservice;

    public UserController(Userservice userservice) {
        this.userservice = userservice;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveCustomer(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "nic") String nic,
            @RequestParam(value = "age") int age,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "roleType") RoleType roleType,
            @RequestParam(value = "contactNumber") String contactNumber,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "profilePic") MultipartFile profilePic) {
        if (profilePic.isEmpty()) {
            throw new RuntimeException("profile Picture is empty...!");
        }
        try {
            userservice.saveUser(new UsersDTO(
                    userId,
                    name,
                    nic,
                    age,
                    gender,
                    email,
                    password,
                    roleType,
                    contactNumber,
                    address,
                    Base64.getEncoder().encodeToString(profilePic.getBytes())));
            return new ResponseEntity<>(" User Saved..!!", HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //--------------------update customer------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "nic") String nic,
            @RequestParam(value = "age") int age,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "roleType") RoleType roleType,
            @RequestParam(value = "contactNumber") String contactNumber,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "profilePic") MultipartFile profilePic) {
        if (profilePic.isEmpty()) {
            throw new RuntimeException("profile Picture is empty...!");
        }
        try {
            UsersDTO customerDTO = new UsersDTO(
                    userId,
                    name,
                    nic,
                    age,
                    gender,
                    email,
                    password,
                    roleType,
                    contactNumber,
                    address,
                    Base64.getEncoder().encodeToString(profilePic.getBytes()));
            userservice.updateUser(customerDTO);
            return new ResponseEntity<>(" User update..!!", HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------Delete customer---------------------------

    @DeleteMapping(params = "userEmail")
    public ResponseEntity<String> deleteUser(String userEmail){
        userservice.deleteUser(userEmail);
        return new ResponseEntity<>(" User deleted..!!",HttpStatus.OK);
    }

    //----------------load data to table----------------------

    @GetMapping(path = "/loadCustomer")
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        return new ResponseEntity<>(userservice.getAllUsers(),HttpStatus.OK);
    }

    //---------Auto generate user id-------------------

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/registerUserIdGenerate")
    public ResponseEntity<String> getLastId(){
        return new ResponseEntity<>(userservice.getLastIndex(),HttpStatus.OK);
    }

    //------------------user Count---------------------------
    @GetMapping(params = "roleType",path = "/countByRoleType")
    public ResponseEntity<Integer> countByRoleType(RoleType roleType){

        return new ResponseEntity<>(userservice.countByRoleType(roleType),HttpStatus.OK);
    }
    @GetMapping(params = "userEmail",path = "/getUser")
    public ResponseEntity<UsersDTO> userFindByEmail(String userEmail){
        return new ResponseEntity<>(userservice.userFindByEmail(userEmail),HttpStatus.OK);
    }
}
