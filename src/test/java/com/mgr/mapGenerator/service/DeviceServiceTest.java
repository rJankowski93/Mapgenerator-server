package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.repository.DeviceRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceTest {

    @InjectMocks
    DeviceService deviceService;

    @Mock
    DeviceRepository deviceRepository;

    @Test
    public void testGetDeviceNamesWhenListContains3Elements() {
        Device device1 = new Device("First");
        Device device2 = new Device("Second");
        Device device3 = new Device("Third");
        Mockito.when(deviceRepository.findAll()).thenReturn(Arrays.asList(device1, device2, device3));

        assertThat(deviceService.getDeviceNames(), CoreMatchers.hasItems("First", "Second", "Third"));
    }

    @Test(expected = ApplicationException.class)
    public void testGetDeviceWhenDeviceNotExist() throws ApplicationException {
        Mockito.when(deviceRepository.findById(any())).thenReturn(Optional.empty());

        deviceService.getDevice(1L);
    }

    @Test(expected = ApplicationException.class)
    public void testSaveDeviceWhenDeviceNotExist() throws ApplicationException, IOException {
        deviceService.saveDevice("");
    }
}