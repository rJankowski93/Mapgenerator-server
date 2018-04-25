package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.data.EncoderData;
import com.mgr.mapGenerator.data.EncoderRawData;
import com.mgr.mapGenerator.repository.DeviceRepository;
import com.mgr.mapGenerator.repository.EncoderDataRepository;
import com.mgr.mapGenerator.repository.EncoderRawDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EncoderService {

    private final EncoderDataRepository encoderDataRepository;

    private final EncoderRawDataRepository encoderRawDataRepository;

    private final DeviceRepository deviceRepository;

    public void refreshData(String deviceName) {
        //TODO sprawdzic
        EncoderData lastEncoderData = encoderDataRepository.findFirstByDeviceNameAndOrderByIdDesc(deviceName).orElse(new EncoderData(0L));
        List<EncoderRawData> encoderRawDataList = encoderRawDataRepository.findAllByDeviceName(deviceName);
        encoderRawDataList
                .stream()
                .filter(encoderRawData -> encoderRawData.getId() > lastEncoderData.getRawDataId())
                .forEach(encoderRawData -> {
                    EncoderData encoderData = new EncoderData();
                    encoderData.setRawDataId(encoderRawData.getId());
                    encoderData.setDeviceName(encoderRawData.getDeviceName());
                    encoderData.setDegrees(calculateTurnDegree(encoderRawData,device));
                    encoderData.setDistance(calculateDistance(encoderRawData));
                    encoderDataRepository.save(encoderData);
                });
    }

    private Double calculateTurnDegree(EncoderRawData encoderRawData) {
        Double differenceDistanceBetweenWheels = encoderRawData.calculateDifferenceDistanceBetweenWheels();
        //TODO pobrac z cache
        return Math.toDegrees(Math.atan(differenceDistanceBetweenWheels / Cache.distanceBetweenWheels));
    }

    private Double calculateDistance(EncoderRawData encoderRawData) {
        Long distance = encoderRawData.getLeft() < encoderRawData.getRight() ? encoderRawData.getRight() : encoderRawData.getLeft();
        return calculateCentimetersDistance(distance);
    }

    private Double calculateCentimetersDistance(Long distance) {
        return ((double) distance / 2000) * 204 / 10;
    }

    public List<EncoderData> getEncoderDataByDeviceName(String deviceName) {
        return encoderDataRepository.findAllByDeviceName(deviceName);
    }

}
