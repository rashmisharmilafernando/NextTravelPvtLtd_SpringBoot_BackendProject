package lk.ijse.userserver.controller;

import lk.ijse.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/loginFrom")
public class LoginController {

    @Autowired
    private UserService userService;

    

}
