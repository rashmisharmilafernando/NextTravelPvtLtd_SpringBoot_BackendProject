package com.rashi.vehicleserver.dao;

import com.rashi.vehicleserver.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface VehicleDAO extends JpaRepository<VehicleEntity,String> {
    @Query(value = "SELECT vehicleId FROM Vehicle ORDER BY vehicleId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(vehicleId) FROM Vehicle",nativeQuery = true)
    int getAllVehicleCount();


    @Query(value = "SELECT * FROM Vehicle WHERE passengers=?1 or transmission=?2 and fuelType=?3", nativeQuery = true)
    ArrayList<VehicleEntity> filterVehicleDetails(String passengers, String transmission, String fuelType);

    List<VehicleEntity> findAllByVehicleCategoryAndVehicleSeatCapacityAndTransmissionTypeAndVehicleFueltype(
            String category,
            int passengers,
            String transmission,
            String fuelType);

    List<VehicleEntity> findAllByVehicleCategory(String vehicleCategory);
}
