package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.data.EncoderData;
import com.mgr.mapGenerator.data.EncoderRawData;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.repository.DeviceRepository;
import com.mgr.mapGenerator.repository.EncoderDataRepository;
import com.mgr.mapGenerator.repository.EncoderRawDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class EncoderServiceTest {

    @InjectMocks
    EncoderService encoderService;

    @Mock
    EncoderDataRepository encoderDataRepository;

    @Mock
    DeviceRepository deviceRepository;

    @Mock
    EncoderRawDataRepository encoderRawDataRepository;

    @Before
    public void setUp() {
        Mockito.when(encoderDataRepository.findFirstByDeviceNameOrderByIdDesc(any())).thenReturn(Optional.empty());
        Mockito.when(encoderDataRepository.save(any())).thenReturn(new EncoderData());
        Mockito.when(deviceRepository.findByName(any())).thenReturn(new Device(0d));
    }

    @Test
    public void testRefreshDataWhenEncoderRawDataListIsEmpty() {
        Mockito.when(encoderRawDataRepository.findAllByDeviceName(any())).thenReturn(new ArrayList<>());

        encoderService.refreshData("Test");

        Mockito.verify(encoderDataRepository, times(0)).save(any());
    }

    @Test
    public void testRefreshDataWhenEncoderRawDataListContains3Elements() {
        EncoderRawData encoderRawData1 = new EncoderRawData(1L, 0L, 0L, 0D, "");
        EncoderRawData encoderRawData2 = new EncoderRawData(1L, 0L, 0L, 0D, "");
        EncoderRawData encoderRawData3 = new EncoderRawData(1L, 0L, 0L, 0D, "");

        Mockito.when(encoderRawDataRepository.findAllByDeviceName(any())).thenReturn(Arrays.asList(encoderRawData1, encoderRawData2, encoderRawData3));

        encoderService.refreshData("Test");

        Mockito.verify(encoderDataRepository, times(3)).save(any());
    }

    @Test
    public void testRefreshDataWhenEncoderRawDataListContains2NewElements() {
        EncoderRawData encoderRawData1 = new EncoderRawData(1L, 0L, 0L, 0D, "");
        EncoderRawData encoderRawData2 = new EncoderRawData(2L, 0L, 0L, 0D, "");
        EncoderRawData encoderRawData3 = new EncoderRawData(3L, 0L, 0L, 0D, "");

        Mockito.when(encoderDataRepository.findFirstByDeviceNameOrderByIdDesc(any())).thenReturn(Optional.of(new EncoderData(1L, 1L)));
        Mockito.when(encoderRawDataRepository.findAllByDeviceName(any())).thenReturn(Arrays.asList(encoderRawData1, encoderRawData2, encoderRawData3));

        encoderService.refreshData("Test");

        Mockito.verify(encoderDataRepository, times(2)).save(any());
    }


}