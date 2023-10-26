package lk.ijse.packageserver.controller;

import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.dto.PackageResponse;
import lk.ijse.packageserver.server.PackageService;
import lk.ijse.packageserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/PackageServer")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageServer) {
        this.packageService = packageServer;
    }
    //--------------------------------Save Vehicle---------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil savePackage(@RequestBody PackageDTO packageDTO){
        packageService.savePackage(packageDTO);
        return new ResponseUtil("OK","Successfully saved...!",null);
    }
    //----------------------------------------Update--------------
    @PutMapping("/update")
    public ResponseUtil UpdatePackage(@PathVariable String packageid,@RequestBody PackageDTO packageDTO){
        packageService.updatePackage(packageid,packageDTO);
        return new ResponseUtil("OK","Successfully saved...!"+packageDTO.getPackageId(),null);
    }

    //------------------------------Delete-----------------
    @DeleteMapping("id")
    public ResponseUtil deletePackage(String id){
        packageService.deletePackage(id);
        return new ResponseUtil("OK","Successfully saved...!"+id,null);
    }
    //---------------Get All--------------------------------
    @GetMapping("/loadPackages")
    public ResponseEntity<List<PackageResponse>>getAllPackages(){
        List<PackageResponse> packageResponses=packageService.getAllPackage().stream().map(e ->
                new PackageResponse(
                        e.getPackageId(),
                        e.getPackageCategory(),
                        e.getNightCount(),
                        e.getTravelArea(),
                        e.getTotalHeadCount(),
                        e.isPetStatus(),
                        e.getPrice()
                )

        ).collect(Collectors.toList());
        return new ResponseEntity<>(packageResponses,HttpStatus.OK);

    }
    //------- Auto Generate id--------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/autoGenerateId")
    public @ResponseBody CustomDTO packageIdGenerate(){
        return packageService.generatePackageId();
    }
    //-----Search package for package table-----------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchPackage",params = {"packageId"})
    public PackageDTO searchPackageId(String packageId){
        return packageService.searchPackage(packageId);
    }

    //-------Package-Count------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/packageCount")
    public @ResponseBody CustomDTO getPackageCount(){
        return packageService.getAllPackageCount();
    }


    //-------Filter package Name------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterPackage",params = {"packageName","PackagePrice"})
    public ArrayList<PackageDTO> filterPackageName(@RequestParam String packageName,@RequestParam double packagePrice){
        return packageService.filterPackageName(packageName,packagePrice);
    }

}
