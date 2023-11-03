package lk.ijse.packageserver.dao;


import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.enetity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PackageDAO extends JpaRepository<PackageEntity,String> {
    @Query(value = "SELECT packageId FROM Package ORDER BY packageId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();


    @Query(value = "SELECT COUNT (packageId) FROM Package ",nativeQuery = true)
    int getAllPackageCount();

    @Query(value = "SELECT * FROM Package WHERE packageCategory=?1 or price=?2", nativeQuery = true)
    ArrayList<PackageEntity> filterPackageName(String packageName,double packagePrice);

    PackageEntity findPackageByPackageCategory(String packageName);
}
