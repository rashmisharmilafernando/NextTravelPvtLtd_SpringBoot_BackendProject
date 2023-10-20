package com.rashi.vehicleserver.dao;

import com.rashi.vehicleserver.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<VehicleEntity,String> {
    @Query(value = "SELECT vehicleId FROM VehicleEntity ORDER BY vehicleId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(vehicleId) FROM VehicleEntity",nativeQuery = true)
    int getAllVehicleCount();
}
