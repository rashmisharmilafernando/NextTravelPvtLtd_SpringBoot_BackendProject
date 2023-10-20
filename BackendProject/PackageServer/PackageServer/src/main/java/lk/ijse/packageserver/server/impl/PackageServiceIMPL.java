package lk.ijse.packageserver.server.impl;

import lk.ijse.packageserver.dao.PackageDAO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.enetity.PackageEntity;
import lk.ijse.packageserver.server.PackageService;
import lk.ijse.packageserver.util.DataConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void updatePackage(String packageid, PackageDTO packageDTO) {
        packageDAO.save(dataConvertor.getPackageEntity(packageDTO));
    }

    @Override
    public void deletePackage(String id) {
        packageDAO.deleteById(id);
    }

    @Override
    public List<PackageDTO> getAllPackage() {
        return dataConvertor.pacackageDTOtoPackageDTOList(packageDAO.findAll());
    }

}
