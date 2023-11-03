package lk.ijse.packageserver.server;


import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;

import java.util.ArrayList;
import java.util.List;

public interface PackageService {
    PackageDTO savePackage(PackageDTO packageDTO);

    void updatePackage(PackageDTO packageDTO);

    void deletePackage(String id);

    ArrayList<PackageDTO> getAllPackage();

    PackageDTO getPackageById(String packageId);

    CustomDTO generatePackageId();

    PackageDTO searchPackage(String packageId);

    CustomDTO getAllPackageCount();

    PackageDTO filterPackageName(String packageCategory);

    List<PackageDTO> getAllPackages();
}
