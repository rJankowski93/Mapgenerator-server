package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.repository.DeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.microedition.io.StreamConnection;
import java.io.*;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class BluetoothServiceTest {

    @InjectMocks
    BluetoothService bluetoothService;

    @Mock
    DeviceRepository deviceRepository;

    @Test(expected = ApplicationException.class)
    public void testConnectWhenDeviceNotExist() throws ApplicationException, IOException {
        Mockito.when(deviceRepository.findById(any())).thenReturn(Optional.empty());
        bluetoothService.connect(0L);
    }

    @Test(expected = ApplicationException.class)
    public void testConnectWhenConnectionIsFailed() throws ApplicationException, IOException {
        Mockito.when(deviceRepository.findById(any())).thenReturn(Optional.of(new Device("", "", "")));
        bluetoothService.connect(0L);
    }

}