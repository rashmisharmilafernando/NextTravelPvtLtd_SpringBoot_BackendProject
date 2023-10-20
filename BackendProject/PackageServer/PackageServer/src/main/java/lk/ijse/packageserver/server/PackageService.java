package lk.ijse.packageserver.server;


import lk.ijse.packageserver.dto.PackageDTO;

import java.util.List;

public interface PackageService {
    PackageDTO savePackage(PackageDTO packageDTO);

    void updatePackage(String packageid, PackageDTO packageDTO);

    void deletePackage(String id);

    List<PackageDTO> getAllPackage();
}
