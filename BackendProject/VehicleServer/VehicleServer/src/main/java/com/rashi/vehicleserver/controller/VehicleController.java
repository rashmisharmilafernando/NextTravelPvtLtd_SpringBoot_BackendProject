package com.rashi.vehicleserver.controller;

import com.rashi.vehicleserver.dto.VehicleDTO;
import com.rashi.vehicleserver.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/vehicle")
public class VehicleController {


    private  final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    VehicleDTO saveVehicle(@RequestBody VehicleDTO vehicleDTO, Errors errors){
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors
                    .getFieldErrors().get(0).getDefaultMessage());
        }
        return vehicleService.saveVehicle(vehicleDTO);
    }
}
