package com.mgr.mapGenerator.data;

import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.exceptions.ApplicationExceptionCodes;

import javax.microedition.io.StreamConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectedDeviceList {
    private List<ConnectedDevice> connectedDevices = new ArrayList<>();

    //TODO distanceBetweenWhhels powinno przychodzic z frontu
    public void add(String deviceName, StreamConnection streamConnection) {
        connectedDevices.add(new ConnectedDevice(deviceName, streamConnection, 1000D));
    }

    public boolean isExist(String name) {
        return connectedDevices
                .stream()
                .anyMatch(connectedDevice -> connectedDevice.equals(name));
    }

    public void remove(String name) {
        connectedDevices
                .removeIf(connectedDevice -> connectedDevice.getDeviceName().equals(name));
    }

    public ConnectedDevice get(String name) throws ApplicationException {
        return connectedDevices
                .stream()
                .filter(connectedDevice -> connectedDevice.getDeviceName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ApplicationExceptionCodes.DEVICE_NOT_FOUND));
    }

    public List<String> getDeviceNames() {
        return connectedDevices
                .stream()
                .map(ConnectedDevice::getDeviceName)
                .collect(Collectors.toList());
    }
}
