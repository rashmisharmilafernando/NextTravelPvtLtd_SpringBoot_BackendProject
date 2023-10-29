package lk.ijse.packageserver.controller;

import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.server.PackageService;
import lk.ijse.packageserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("api/v1/package")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageServer) {
        this.packageService = packageServer;
    }
    //--------------------------------Save Vehicle---------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil savePackage(@ModelAttribute PackageDTO packageDTO){
        packageService.savePackage(packageDTO);
        return new ResponseUtil("OK","Successfully saved...!",null);
    }
    //----------------------------------------Update--------------
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public ResponseUtil updatePackage(@ModelAttribute PackageDTO packageDTO) {
        packageService.updatePackage(packageDTO);
        return new ResponseUtil("OK", "Successfully saved...!" + packageDTO.getPackageId(), null);
    }


    //------------------------------Delete-----------------
    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"})
    public ResponseEntity<String> deletePackage(String id){
        packageService.deletePackage(id);
        return ResponseEntity.ok("Package deleted successfully.");
    }
    //---------------Get All--------------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/loadPackages")
    public ResponseUtil getAllPackages() {
        return new ResponseUtil("Ok","Successfully",packageService.getAllPackage());
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
    @GetMapping(path = "/filterPackage",params = {"packageCategory","price"})
    public ArrayList<PackageDTO> filterPackageName(@RequestParam String packageCategory,@RequestParam double price){
        return packageService.filterPackageName(packageCategory,price);
    }

}
