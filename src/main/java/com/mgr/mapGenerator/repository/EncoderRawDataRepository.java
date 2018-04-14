package com.mgr.mapGenerator.repository;

import com.mgr.mapGenerator.data.EncoderRawData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncoderRawDataRepository extends JpaRepository<EncoderRawData, Long> {
}
