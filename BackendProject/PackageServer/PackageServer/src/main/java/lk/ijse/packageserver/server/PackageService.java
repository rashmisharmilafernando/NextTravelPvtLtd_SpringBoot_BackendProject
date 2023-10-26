package lk.ijse.packageserver.server;


import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;

import java.util.ArrayList;
import java.util.List;

public interface PackageService {
    PackageDTO savePackage(PackageDTO packageDTO);

    void updatePackage(String packageid, PackageDTO packageDTO);

    void deletePackage(String id);

    List<PackageDTO> getAllPackage();

    PackageDTO getPackageById(String packageId);

    CustomDTO generatePackageId();

    PackageDTO searchPackage(String packageId);

    CustomDTO getAllPackageCount();

    ArrayList<PackageDTO> filterPackageName(String packageName,double packagePrice);
}
