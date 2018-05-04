package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.repository.DeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
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

//    @Test
//    public void shouldReturn() throws IOException {
//        Mockito.when(connectedDevice.getStreamConnection()).thenReturn(createStreamConnection());
//        Mockito.when(connectedDevice.getDeviceName()).thenReturn("TEST DEVICE");
//        Mockito.doCallRealMethod().when(bluetoothService).getData(connectedDevice);
//        Cache.connectedDeviceList.add("TEST DEVICE", null);
////        Mockito.when(ioUtils.toString(Mockito.anyObject(), "UTF-8")).thenReturn("ABC");
//
//        bluetoothService.getData(connectedDevice);
//    }

//    private StreamConnection createStreamConnection() {
//        return new StreamConnection() {
//            @Override
//            public InputStream openInputStream() throws IOException {
//                return inputStream;
//            }
//
//            @Override
//            public DataInputStream openDataInputStream() throws IOException {
//                return null;
//            }
//
//            @Override
//            public OutputStream openOutputStream() throws IOException {
//                return null;
//            }
//
//            @Override
//            public DataOutputStream openDataOutputStream() throws IOException {
//                return null;
//            }
//
//            @Override
//            public void close() throws IOException {
//
//            }
//        };
//    }
}