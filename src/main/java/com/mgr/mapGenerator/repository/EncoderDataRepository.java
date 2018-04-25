package com.mgr.mapGenerator.repository;

import com.mgr.mapGenerator.data.EncoderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EncoderDataRepository extends JpaRepository<EncoderData, Long> {

    Optional<EncoderData> findFirstByDeviceNameAndOrderByIdDesc(String deviceName);

    List<EncoderData> findAllByDeviceName(String deviceName);
}
