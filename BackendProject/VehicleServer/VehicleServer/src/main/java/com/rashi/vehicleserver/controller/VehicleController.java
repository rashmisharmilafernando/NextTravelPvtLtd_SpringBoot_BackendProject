package com.rashi.vehicleserver.controller;

import com.rashi.vehicleserver.dto.CustomDTO;
import com.rashi.vehicleserver.dto.VehicleDTO;
import com.rashi.vehicleserver.dto.VehicleResponse;
import com.rashi.vehicleserver.service.VehicleService;
import com.rashi.vehicleserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("api/v1/vehicle")
public class VehicleController {


    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //--------------------------------Save Vehicle--------------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveVehicle(
          @RequestParam(value ="vehicleid") String vehicleId,
            @RequestParam(value ="vehiclebrand") String vehicleBrand,
            @RequestParam(value ="vehicleCategory") String category,
            @RequestParam(value ="vehicleFueltype") String fuelType,
            @RequestParam(value ="hybrid_Status") boolean isHybrid,
            @RequestParam(value ="vehicleFuelUsage") double fuelUsage,
            @RequestParam(value ="vehicleSeatCapacity") int seatCapacity,
            @RequestParam(value ="vehicleType") String vehicleType,
            @RequestParam(value ="TransmissionType") String transmission,
            @RequestParam(value ="vehicleDriverName") String driverName,
            @RequestParam(value ="vehicleDriveNumber") String driverNumber,
            @RequestParam(value ="license") MultipartFile driverLicense,
            @RequestParam(value ="vehicleRearView") MultipartFile rearView,
            @RequestParam(value ="vehicle_Font_View") MultipartFile frontView,
            @RequestParam(value ="vehicle_Side_View") MultipartFile sideView,
            @RequestParam(value ="vehicle_OtherSide_View") MultipartFile otherSideView

            ) {
        if (frontView.isEmpty() && rearView.isEmpty() && sideView.isEmpty() && otherSideView.isEmpty() && driverLicense.isEmpty()) {
            throw new RuntimeException("This Image is empty..!");
        }
        try {
            vehicleService.saveVehicle(new VehicleDTO(
                   vehicleId,
                    vehicleBrand,
                    category,
                    fuelType,
                    isHybrid,
                    fuelUsage,
                    seatCapacity,
                    vehicleType,
                    transmission,
                    driverName,
                    driverNumber,
                    Base64.getEncoder().encodeToString(driverLicense.getBytes()),
                    Base64.getEncoder().encodeToString(rearView.getBytes()),
                    Base64.getEncoder().encodeToString(frontView.getBytes()),
                    Base64.getEncoder().encodeToString(sideView.getBytes()),
                    Base64.getEncoder().encodeToString(otherSideView.getBytes())));

            return new ResponseUtil("OK", "Successfully Registered...!", null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //----------------------------------------Update------------------------------------
    @PutMapping("/update")
    public ResponseUtil UpdateVehicle(
            @RequestParam String vehicleId,
            @RequestParam String vehicleBrand,
            @RequestParam String category,
            @RequestParam String fuelType,
            @RequestParam boolean isHybrid,
            @RequestParam double fuelUsage,
            @RequestParam int seatCapacity,
            @RequestParam String vehicleType,
            @RequestParam String transmission,
            @RequestParam String driverName,
            @RequestParam String driverNumber,
            @RequestParam MultipartFile driverLicense,
            @RequestParam MultipartFile rearView,
            @RequestParam MultipartFile frontView,
            @RequestParam MultipartFile sideView,
            @RequestParam MultipartFile otherSideView

    ) {
        if (frontView.isEmpty() && rearView.isEmpty() && sideView.isEmpty() && otherSideView.isEmpty() && driverLicense.isEmpty()) {
            throw new RuntimeException("This Image is empty..!");
        }
        try {
            VehicleDTO vehicleDTO = new VehicleDTO(
                    vehicleId,
                    vehicleBrand,
                    category,
                    fuelType,
                    isHybrid,
                    fuelUsage,
                    seatCapacity,
                    vehicleType,
                    transmission,
                    driverName,
                    driverNumber,
                    Base64.getEncoder().encodeToString(driverLicense.getBytes()),

                    Base64.getEncoder().encodeToString(rearView.getBytes()),
                    Base64.getEncoder().encodeToString(frontView.getBytes()),
                    Base64.getEncoder().encodeToString(sideView.getBytes()),
                    Base64.getEncoder().encodeToString(otherSideView.getBytes())
            );
            vehicleService.updateVehicle(vehicleDTO);
            return new ResponseUtil("OK", "Successfully updated..." + vehicleDTO.getVehicleId(), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------Delete----------------------------------
    @DeleteMapping("id")
    public ResponseUtil deleteVehicle(@RequestParam String id) {
        vehicleService.deleteVehicle(id);
        return new ResponseUtil("OK", "Successfully Deleted...!" + id, null);
    }

    //---------------Get All--------------------------------------------------
    @GetMapping(path = "/loadAllVehicle")
    public ResponseEntity<List<VehicleResponse>> getAllVehicle() {
        List<VehicleResponse> vehicleResponses = vehicleService.getAllVehicle().stream().map(e ->
                new VehicleResponse(
                        e.getVehicleId(),
                        e.getVehicleBrand(),
                        e.getCategory(),
                        e.getFuelType(),
                        e.isHybrid(),
                        e.getSeatCapacity(),
                        e.getVehicleType(),
                        e.getTransmission(),
                        e.getDriverName(),
                        e.getDriverNumber()
                )
        ).collect(Collectors.toList());
        return new ResponseEntity<>(vehicleResponses, HttpStatus.OK);
    }

    //------- Auto Generate id--------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/autoGenerateId")
    public @ResponseBody CustomDTO vehicleGenerate() {
        System.out.println("autoGenerateId");
        return vehicleService.vehicleIdGenerate();
    }

    //------- Search Vehicle for vehicle table--------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchVehicle", params = {"vehicleId"})
    public VehicleDTO searchVehicleId(String vehicle_Id) {
        return vehicleService.searchVehicleId(vehicle_Id);
    }

    //-------Vehicle-Count------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/vehiclesCount")
    public @ResponseBody CustomDTO getSumVehicle() {
        return vehicleService.getAllVehicleCount();
    }

    //-------Filter Vehicle details------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterVehicle", params = {"passengers", "transmission", "fuelType"})
    public ArrayList<VehicleDTO> filterVehicleDetails(@RequestParam String passengers, @RequestParam String transmission, @RequestParam String fuelType) {
        return vehicleService.flterVehicleDetails(passengers, transmission, fuelType);
    }
    //-----------------------------------------------------------------


}


