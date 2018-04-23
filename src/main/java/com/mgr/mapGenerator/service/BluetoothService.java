package com.mgr.mapGenerator.service;


import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.data.ConnectedDevice;
import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.data.EncoderRawData;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.exceptions.ApplicationExceptionCodes;
import com.mgr.mapGenerator.repository.DeviceRepository;
import com.mgr.mapGenerator.repository.EncoderRawDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BluetoothService implements ConnectService {

    private final EncoderRawDataRepository encoderRawDataRepository;

    private final DeviceRepository deviceRepository;

    public void connect(Long deviceId) throws ApplicationException {
        try {
            Optional<Device> device = deviceRepository.findById(deviceId);
            if (device.isPresent()) {
                Cache.connectedDeviceList.add(device.get().getName(), (StreamConnection) Connector.open(device.get().getUrl()));
            } else {
                throw new ApplicationException(ApplicationExceptionCodes.DEVICE_NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApplicationException(ApplicationExceptionCodes.CONNECTION_FAILED);
        }
    }

    public void getData(ConnectedDevice connectedDevice) {
        try (InputStream is = connectedDevice.getStreamConnection().openInputStream()) {
            long counter = 0;
            byte[] temp = new byte[100];
            StringBuilder data = new StringBuilder();
            while (!Cache.connectedDeviceList.isExist(connectedDevice.getDeviceName())) {
                is.read(temp);
                data.append(new String(temp).trim());
                Arrays.fill(temp, (byte) 0);
                if (data.length() == 0) {
                    counter++;
                }
                if (counter == 10) {
                    Cache.connectedDeviceList.remove(connectedDevice.getDeviceName());
                    System.out.println("********************END******************");
                }
                if (data.toString().startsWith("LS-") && data.toString().endsWith("-RE")) {
                    counter = 0;
                    String[] parts = data.toString().split("-");
                    List<Long> lista = new ArrayList<>();
                    System.out.println(data.toString());
                    for (String part : parts) {
                        if (!part.contains("LS") && !part.contains("RE") && !part.contains("LE") && !part.contains("RS")) {
                            lista.add(Long.valueOf(part));
                        }
                        if (lista.size() >= 2) {
                            if (lista.get(0) > 0 || lista.get(1) > 0)
                                encoderRawDataRepository.save(new EncoderRawData(lista.get(0), lista.get(1), connectedDevice.getDeviceName()));
                            lista.clear();
                        }
                    }

                    data = new StringBuilder();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
