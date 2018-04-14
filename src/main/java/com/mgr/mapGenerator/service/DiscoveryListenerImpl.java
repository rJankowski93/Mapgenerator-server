package com.mgr.mapGenerator.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Getter
public class DiscoveryListenerImpl implements DiscoveryListener {

    private Set<RemoteDevice> remoteDevices = new HashSet<>();

    @Setter
    private boolean scanFinished = false;

    @Override
    public void deviceDiscovered(RemoteDevice device, DeviceClass deviceClass) {
        remoteDevices.add(device);
    }

    @Override
    public void servicesDiscovered(int transID, ServiceRecord[] serviceRecords) {
    }

    @Override
    public void serviceSearchCompleted(int transID, int respCode) {

    }

    @Override
    public void inquiryCompleted(int discType) {
        scanFinished = true;
    }

}
