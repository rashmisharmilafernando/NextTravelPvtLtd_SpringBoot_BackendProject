package lk.ijse.packageserver.dao;


import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.enetity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDAO extends JpaRepository<PackageEntity,String> {
}
