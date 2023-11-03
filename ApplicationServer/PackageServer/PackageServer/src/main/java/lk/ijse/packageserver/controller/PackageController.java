package lk.ijse.packageserver.controller;

import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.server.PackageService;
import lk.ijse.packageserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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



    //-------Package-Count------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/packageCount")
    public @ResponseBody CustomDTO getPackageCount(){
        return packageService.getAllPackageCount();
    }


    //-------get package Name------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterPackage",params = {"packageCategoryByPackageCategory"})
    public ResponseEntity<PackageDTO> filterPackageName(@RequestParam String packageCategory){
        return new ResponseEntity<>(packageService.filterPackageName(packageCategory),HttpStatus.OK);
    }

    //------------get all package names---------------------
    @GetMapping(path = "/getPackageNameList")
    public ResponseEntity<List<String>> getPackageNameList(){
        List<String> packageNameList = null;
        List<PackageDTO> allPackages = packageService.getAllPackages();
        for(PackageDTO packageDTO : allPackages){
            packageNameList.add(packageDTO.getPackageCategory());
        }
        return new ResponseEntity<>(packageNameList,HttpStatus.OK);
    }

}
