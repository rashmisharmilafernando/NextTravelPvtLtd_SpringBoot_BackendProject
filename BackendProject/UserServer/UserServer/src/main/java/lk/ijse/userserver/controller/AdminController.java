package lk.ijse.userserver.controller;

import lk.ijse.userserver.dto.AdminDTO;
import lk.ijse.userserver.service.AdminService;
import lk.ijse.userserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class AdminController {

    public final AdminService adminService;

    public AdminController(AdminService userService) {
        this.adminService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveUser(@ModelAttribute AdminDTO userDTO){
        adminService.saveUser(userDTO);
        return new ResponseUtil("OK","Successfully save User..!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public ResponseUtil updateUser(@ModelAttribute AdminDTO userDTO){
        adminService.updateUser(userDTO);
        return new ResponseUtil("OK","Successfully updated...!",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"/id"})
    public ResponseUtil deleteUser(@RequestParam String id){
        adminService.deleteUser(id);
        return new ResponseUtil("OK","Successfully Delete",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path="/loadAllUser")
    public ResponseUtil getAllUser(){

        return new ResponseUtil("OK","Succesddfully Loaded ",adminService.getAllUser());
    }
}
