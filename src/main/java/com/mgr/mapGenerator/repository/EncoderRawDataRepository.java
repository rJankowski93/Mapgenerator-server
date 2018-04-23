package com.mgr.mapGenerator.repository;

import com.mgr.mapGenerator.data.EncoderData;
import com.mgr.mapGenerator.data.EncoderRawData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncoderRawDataRepository extends JpaRepository<EncoderRawData, Long> {

    List<EncoderRawData> findAllByDeviceName(String deviceName);
}
