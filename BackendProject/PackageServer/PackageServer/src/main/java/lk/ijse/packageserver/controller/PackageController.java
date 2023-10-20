package lk.ijse.packageserver.controller;

import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.dto.PackageResponse;
import lk.ijse.packageserver.server.PackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PackageDTO savePackage(

            @RequestParam String packageId,
            @RequestParam String packageCategory,
            @RequestParam int nightCount,
            @RequestParam String travelArea,
            @RequestParam int totalHeadCount,
            @RequestParam boolean petStatus,
            @RequestParam double price
    ) {
        PackageDTO packageDTO = new PackageDTO(
                packageId,
                packageCategory,
                nightCount,
                travelArea,
                totalHeadCount,
                petStatus,
                price
        );
        return packageService.savePackage(packageDTO);
    }


    @PutMapping("packageId")
    public void UpdatePackage(@PathVariable String packageid,@RequestBody PackageDTO packageDTO){
        packageService.updatePackage(packageid,packageDTO);
    }

    @DeleteMapping("id")
    public void deletePackage(String id){
        packageService.deletePackage(id);
    }

    @GetMapping
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

}
