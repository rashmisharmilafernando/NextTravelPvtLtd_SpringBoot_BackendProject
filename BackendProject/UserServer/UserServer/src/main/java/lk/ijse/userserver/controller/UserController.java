package lk.ijse.userserver.controller;

import lk.ijse.userserver.dto.UserDTO;
import lk.ijse.userserver.service.UserService;
import lk.ijse.userserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveUser(@ModelAttribute UserDTO userDTO){
        userService.saveUser(userDTO);
        return new ResponseUtil("OK","Successfully save User..!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public ResponseUtil updateUser(@ModelAttribute UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseUtil("OK","Successfully updated...!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"/id"})
    public ResponseUtil deleteUser(@RequestParam String id){
        userService.deleteUser(id);
        return new ResponseUtil("OK","Successfully Delete",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path="/loadAllUser")
    public ResponseUtil getAllUser(){

        return new ResponseUtil("OK","Succesddfully Loaded ",userService.getAllUser());
    }
}
