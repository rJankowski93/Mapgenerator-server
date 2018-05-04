package com.mgr.mapGenerator.service;


import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.data.ConnectedDevice;
import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.data.EncoderRawData;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.exceptions.ApplicationExceptionCodes;
import com.mgr.mapGenerator.repository.DeviceRepository;
import com.mgr.mapGenerator.repository.EncoderRawDataRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


@Service
@RequiredArgsConstructor
public class BluetoothService implements ConnectService {

    private final EncoderRawDataRepository encoderRawDataRepository;

    private final DeviceRepository deviceRepository;

    public void connect(Long deviceId) throws ApplicationException {
        try {
            Device device = deviceRepository
                    .findById(deviceId)
                    .orElseThrow(() -> new ApplicationException(ApplicationExceptionCodes.DEVICE_NOT_FOUND));
            Cache.connectedDeviceList.add(device.getName(), (StreamConnection) Connector.open(device.getUrl()));
        } catch (IOException e) {
            throw new ApplicationException(ApplicationExceptionCodes.CONNECTION_FAILED);
        }
    }

    //TODO refactor InputStream
    //TODO add UnitTest
    public void getData(ConnectedDevice connectedDevice) {
        try (InputStream is = connectedDevice.getStreamConnection().openInputStream()) {
            long counter = 0;
            byte[] temp = new byte[100];
            StringBuilder data = new StringBuilder();
            while (Cache.connectedDeviceList.isExist(connectedDevice.getDeviceName())) {
                is.read(temp);
                data.append(new String(temp).trim());
                Arrays.fill(temp, (byte) 0);
                if (counter == 100) {
                    Cache.connectedDeviceList.remove(connectedDevice.getDeviceName());
                }
                // S-12-15-23-E  12(left motor), 15(right motor), 23(sensor)
                if (data.toString().startsWith("S-") && data.toString().endsWith("-E")) {
                    counter = 0;
                    String[] parts = data.toString().split("-");
                    Long leftMotor = Long.valueOf(parts[1]);
                    Long rightMotor = Long.valueOf(parts[2]);
                    Double sensor = Double.valueOf(parts[3]);
                    if (leftMotor > 0 || rightMotor > 0) {
                        encoderRawDataRepository.save(new EncoderRawData(leftMotor, rightMotor, sensor, connectedDevice.getDeviceName()));
                    }
                    data = new StringBuilder();
                }
                else{
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
