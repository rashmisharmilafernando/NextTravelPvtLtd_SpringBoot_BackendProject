package com.rashi.vehicleserver.controller;

import com.rashi.vehicleserver.dto.VehicleDTO;
import com.rashi.vehicleserver.dto.VehicleResponse;
import com.rashi.vehicleserver.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/vehicle")
public class VehicleController {


    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //Save Vehicle
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public VehicleDTO saveVehicle(
            @RequestParam String vehicleId,
            @RequestParam String vehicleBrand,
            @RequestParam String category,
            @RequestParam String fuelType,
            @RequestParam boolean isHybrid,
            @RequestParam double fuelUsage,
            @RequestParam MultipartFile frontView,
            @RequestParam MultipartFile rearView,
            @RequestParam MultipartFile sideView,
            @RequestParam MultipartFile otherSideView,
            @RequestParam int seatCapacity,
            @RequestParam String vehicleType,
            @RequestParam String transmission,
            @RequestParam String driverName,
            @RequestParam String driverNumber,
            @RequestParam MultipartFile driverLicense
    ) {
        if (frontView.isEmpty() && rearView.isEmpty() && sideView.isEmpty() && otherSideView.isEmpty() && driverLicense.isEmpty()) {
            throw new RuntimeException("This Image is empty..!");
        }
        try {
            String front_View = Base64.getEncoder().encodeToString(frontView.getBytes());
            String rear_View = Base64.getEncoder().encodeToString(rearView.getBytes());
            String side_View = Base64.getEncoder().encodeToString(sideView.getBytes());
            String other_Side_View = Base64.getEncoder().encodeToString(otherSideView.getBytes());
            String driver_License = Base64.getEncoder().encodeToString(driverLicense.getBytes());

            VehicleDTO vehicleDTO = new VehicleDTO(
                    vehicleId,
                    vehicleBrand,
                    category,
                    fuelType,
                    isHybrid,
                    fuelUsage,
                    front_View,
                    rear_View,
                    side_View,
                    other_Side_View,
                    seatCapacity,
                    vehicleType,
                    transmission,
                    driverName,
                    driverNumber,
                    driver_License
            );
            return vehicleService.saveVehicle(vehicleDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Update
    @PutMapping("vehicleId")
    public void UpdateVehicle(@PathVariable String veicleId,@RequestBody VehicleDTO vehicleDTO){
        vehicleService.updateVehicle(veicleId,vehicleDTO);
    }

    @DeleteMapping("id")
    public void deleteEmployee(String id){
        vehicleService.deleteVehicle(id);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>>getAllVehicle(){
        List<VehicleResponse> vehicleResponses=vehicleService.getAllVehicle().stream().map(e ->
                new VehicleResponse(

                )
        ).collect(Collectors.toList());
        return new ResponseEntity<>(vehicleResponses,HttpStatus.OK);
    }
}

