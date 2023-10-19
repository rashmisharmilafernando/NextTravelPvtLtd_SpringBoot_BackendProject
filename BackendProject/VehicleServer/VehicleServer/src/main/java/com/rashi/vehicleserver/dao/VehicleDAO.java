package com.rashi.vehicleserver.dao;

import com.rashi.vehicleserver.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<VehicleEntity,String> {

}
