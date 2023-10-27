package lk.ijse.packageserver.server.impl;

import lk.ijse.packageserver.dao.PackageDAO;
import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.enetity.PackageEntity;
import lk.ijse.packageserver.server.PackageService;
import lk.ijse.packageserver.util.DataConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PackageServiceIMPL implements PackageService {

    @Autowired
    private DataConvertor dataConvertor;

    @Autowired
    private PackageDAO packageDAO;


    @Override
    public PackageDTO savePackage(PackageDTO packageDTO) {
        PackageEntity packageEntity = dataConvertor.getPackageEntity(packageDTO);
        packageDAO.save(packageEntity);
        return packageDTO;
    }

    @Override
    public void updatePackage(PackageDTO packageDTO) {
        packageDAO.save(dataConvertor.getPackageEntity(packageDTO));
    }

    @Override
    public void deletePackage(String id) {
        packageDAO.deleteById(id);
    }

    @Override
    public ArrayList<PackageDTO> getAllPackage() {
        List<PackageEntity> packageEntities=packageDAO.findAll();
        return dataConvertor.pacackageDTOtoPackageDTOList(packageEntities);

    }

    @Override
    public PackageDTO getPackageById(String packageId) {
        return dataConvertor.getPackageDTO((PackageEntity) packageDAO.findAllById(Collections.singleton(packageId)));
    }

    @Override
    public CustomDTO generatePackageId() {
        return new CustomDTO(packageDAO.getLastIndex());
    }

    @Override
    public PackageDTO searchPackage(String packageId) {
        if (!packageDAO.existsById(packageId)){
            throw new RuntimeException("Wrong Id..!");
        }
        PackageEntity packageEntity=packageDAO.findById(packageId).get();
        return dataConvertor.getPackageDTO(packageEntity);
    }

    @Override
    public CustomDTO getAllPackageCount() {
        return new CustomDTO(packageDAO.getAllPackageCount());
    }

    @Override
    public ArrayList<PackageDTO> filterPackageName(String packageName,double packagePrice) {
        return (ArrayList<PackageDTO>) packageDAO.filterPackageName(packageName,packagePrice).stream().map(packageEntity ->dataConvertor.getPackageDTO(packageEntity)).collect(Collectors.toList());
    }

}
