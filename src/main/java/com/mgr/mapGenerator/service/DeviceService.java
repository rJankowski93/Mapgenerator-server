package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Cache;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DiscoveryListenerImpl discoveryListener;

    private final DeviceRepository deviceRepository;

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public List<String> getDeviceNames() {
        return deviceRepository
                .findAll()
                .stream()
                .map(Device::getName)
                .collect(Collectors.toList());
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
        for (RemoteDevice remoteDevice : discoveryListener.getRemoteDevices()) {
            Cache.foundDeviceList.add(new Device(remoteDevice.getFriendlyName(false), remoteDevice.getBluetoothAddress(), URLUtil.createDeviceUrl(remoteDevice)));
        }
        return Cache.foundDeviceList;
    }

    public Device saveDevice(String name) throws IOException, ApplicationException {
        Device foundDevice = Cache.foundDeviceList
                .stream()
                .filter(device -> device.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ApplicationExceptionCodes.DEVICE_NOT_FOUND));
        return deviceRepository.save(foundDevice);
    }

}
