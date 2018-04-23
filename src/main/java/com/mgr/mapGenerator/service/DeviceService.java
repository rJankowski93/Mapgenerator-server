package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.exceptions.ApplicationExceptionCodes;
import com.mgr.mapGenerator.repository.DeviceRepository;
import com.mgr.mapGenerator.util.URLUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DiscoveryListenerImpl discoveryListener;

    private final DeviceRepository deviceRepository;

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public Device getDevice(Long id) throws ApplicationException {
        return deviceRepository.findById(id).orElseThrow(() -> new ApplicationException(ApplicationExceptionCodes.DEVICE_NOT_FOUND));
    }

    public void remove(Long id) {
        deviceRepository.deleteById(id);
    }

    public List<Device> searchDevices() throws IOException, InterruptedException {
        discoveryListener.setScanFinished(false);
        LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, discoveryListener);
        while (!discoveryListener.isScanFinished()) {
        }
        List<Device> devices = new ArrayList<>();
        for (RemoteDevice remoteDevice : discoveryListener.getRemoteDevices()) {
            devices.add(new Device(remoteDevice.getFriendlyName(false), remoteDevice.getBluetoothAddress(), URLUtil.createDeviceUrl(remoteDevice)));
        }
        return devices;
    }

    public Device saveDevice(String name) throws IOException {
        discoveryListener.setScanFinished(false);
        LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, discoveryListener);
        while (!discoveryListener.isScanFinished()) {
        }
        for (RemoteDevice remoteDevice : discoveryListener.getRemoteDevices()) {
            if (name.equals(remoteDevice.getFriendlyName(false))) {
                return deviceRepository.save(new Device(remoteDevice.getFriendlyName(false), remoteDevice.getBluetoothAddress(), URLUtil.createDeviceUrl(remoteDevice)));
            }
        }
        return null;
    }

}
