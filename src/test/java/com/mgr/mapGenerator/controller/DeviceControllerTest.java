package com.mgr.mapGenerator.controller;

import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.exceptions.ApplicationException;
import com.mgr.mapGenerator.exceptions.ApplicationExceptionCodes;
import com.mgr.mapGenerator.service.ConnectService;
import com.mgr.mapGenerator.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DeviceController.class)
public class DeviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeviceService deviceService;

    @Test
    public void shouldReturnOkStatusForGetDevices() throws Exception {
        Mockito.when(deviceService.getDevices()).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/device/devices")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOkStatusForGetDevice() throws Exception {
        Mockito.when(deviceService.getDevice(any())).thenReturn(new Device());

        this.mockMvc.perform(get("/device/123")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNotFoundStatusForGetDeviceWhenDeviceNotExist() throws Exception {
        Mockito.when(deviceService.getDevice(any())).thenThrow(new ApplicationException(ApplicationExceptionCodes.DEVICE_NOT_FOUND));

        this.mockMvc.perform(get("/device/123")).andDo(print()).andExpect(status().isNotFound());
    }
}