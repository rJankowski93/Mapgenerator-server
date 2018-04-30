package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.data.ConnectedDevice;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.microedition.io.StreamConnection;
import java.io.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BluetoothServiceTest {

    @Mock
    BluetoothService bluetoothService;

    @Mock
    ConnectedDevice connectedDevice;

    @Mock
    InputStream inputStream;

    @Mock
    IOUtils ioUtils;

    @Test
    public void shouldReturn() throws IOException {
        Mockito.when(connectedDevice.getStreamConnection()).thenReturn(createStreamConnection());
        Mockito.when(connectedDevice.getDeviceName()).thenReturn("TEST DEVICE");
        Mockito.doCallRealMethod().when(bluetoothService).getData(connectedDevice);
        Cache.connectedDeviceList.add("TEST DEVICE", null);
//        Mockito.when(ioUtils.toString(Mockito.anyObject(), "UTF-8")).thenReturn("ABC");

        bluetoothService.getData(connectedDevice);
    }

    private StreamConnection createStreamConnection() {
        return new StreamConnection() {
            @Override
            public InputStream openInputStream() throws IOException {
                return inputStream;
            }

            @Override
            public DataInputStream openDataInputStream() throws IOException {
                return null;
            }

            @Override
            public OutputStream openOutputStream() throws IOException {
                return null;
            }

            @Override
            public DataOutputStream openDataOutputStream() throws IOException {
                return null;
            }

            @Override
            public void close() throws IOException {

            }
        };
    }
}