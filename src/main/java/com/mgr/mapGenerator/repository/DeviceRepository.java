package com.mgr.mapGenerator.repository;

import com.mgr.mapGenerator.data.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByName(String name);
}
