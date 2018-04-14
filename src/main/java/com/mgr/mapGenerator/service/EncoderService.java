package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.data.EncoderData;
import com.mgr.mapGenerator.data.EncoderRawData;
import com.mgr.mapGenerator.repository.EncoderDataRepository;
import com.mgr.mapGenerator.repository.EncoderRawDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EncoderService {

    private final EncoderDataRepository encoderDataRepository;

    private final EncoderRawDataRepository encoderRawDataRepository;

    public List<EncoderData> generateData() {
        List<EncoderData> encoderDataList = new ArrayList<>();
        List<EncoderRawData> encoderRawDataList = encoderRawDataRepository.findAll();
        for (EncoderRawData rawData : encoderRawDataList) {
            EncoderData encoderData = new EncoderData();
            Double differenceDistanceBetweenWheels = Double.valueOf(rawData.getLeft()) - Double.valueOf(rawData.getRight());
            Double degrees = Math.toDegrees(Math.atan(differenceDistanceBetweenWheels / Cache.distanceBetweenWheels));
            encoderData.setDegrees(degrees);
            Long distance;
            if (rawData.getLeft() < rawData.getRight()) {
                distance = rawData.getRight();
            } else {
                distance = rawData.getLeft();
            }
            Double centimetersDistance = ((double) distance / 2000) * 204 / 10;
            encoderData.setDistance(centimetersDistance);
            encoderDataRepository.save(encoderData);
            encoderDataList.add(encoderData);
        }
        return encoderDataList;
    }

    public List<EncoderData> getAll() {
        return encoderDataRepository.findAll();
    }

}
