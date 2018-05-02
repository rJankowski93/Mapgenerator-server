package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.*;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.repository.DeviceRepository;
import com.mgr.mapGenerator.repository.EncoderDataRepository;
import com.mgr.mapGenerator.repository.EncoderRawDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EncoderService {

    private final EncoderDataRepository encoderDataRepository;

    private final EncoderRawDataRepository encoderRawDataRepository;

    private final DeviceRepository deviceRepository;

    public void refreshData(String deviceName) throws ApplicationException {
        EncoderData lastEncoderData = encoderDataRepository.findFirstByDeviceNameOrderByIdDesc(deviceName).orElse(new EncoderData(0L,0L));
        List<EncoderRawData> encoderRawDataList = encoderRawDataRepository.findAllByDeviceName(deviceName);
        Device selectedDevice = deviceRepository.findByName(deviceName);
        encoderRawDataList
                .stream()
                .filter(encoderRawData -> encoderRawData.getId() > lastEncoderData.getRawDataId())
                .forEach(encoderRawData -> {
                    EncoderData encoderData = new EncoderData();
                    encoderData.setRawDataId(encoderRawData.getId());
                    encoderData.setDeviceName(encoderRawData.getDeviceName());
                    encoderData.setDegrees(calculateTurnDegree(encoderRawData, selectedDevice));
                    encoderData.setDistance(calculateDistance(encoderRawData));
                    encoderData.setSensor(encoderRawData.getSensor());
                    encoderDataRepository.save(encoderData);
                });
    }

    private Double calculateTurnDegree(EncoderRawData encoderRawData, Device selectedDevice) {
        Double differenceTraveledDistance = encoderRawData.calculateDifferenceTraveledDistance();
        Double distanceBetweenWheels = selectedDevice.getDistanceBetweenWheels();
        return Math.toDegrees(Math.atan(differenceTraveledDistance / distanceBetweenWheels));
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
