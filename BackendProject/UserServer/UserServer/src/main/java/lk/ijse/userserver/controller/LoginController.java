package lk.ijse.userserver.controller;

import lk.ijse.userserver.service.AdminService;
import lk.ijse.userserver.service.Userservice;
import lk.ijse.userserver.util.CurrentUser;
import lk.ijse.userserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/loginFrom")
public class LoginController {

    @Autowired
    private Userservice userService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("OK","Successfully Loaded...!",userService.getAllUsers());
    }

    @GetMapping(params = {"username"})
    public ResponseUtil currentUser(String username,String password){
        CurrentUser.currentUser=userService.getUsernamePassword(username,password);
        return new ResponseUtil("OK","Successfully loaded....!","");
    }



}
