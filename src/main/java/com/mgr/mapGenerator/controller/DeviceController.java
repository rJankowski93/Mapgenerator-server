package com.mgr.mapGenerator.controller;

import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.data.Device;
import com.mgr.mapGenerator.service.ConnectService;
import com.mgr.mapGenerator.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    private final ConnectService connectService;

    @RequestMapping(value = "/devices", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Device>> getDevices() {
        return ResponseEntity.ok(deviceService.getDevices());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Device> getDevice(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(deviceService.getDevice(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<Device>> searchDevices() {
        try {
            return ResponseEntity.ok(deviceService.searchDevices());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Device> saveDevices(@RequestBody String name, UriComponentsBuilder uriBuilder) {
        try {
            Device device = deviceService.saveDevice(name);
            URI uri = uriBuilder.path("/device/{id}").buildAndExpand(device.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @RequestMapping("connect/{deviceId}")
    public ResponseEntity connect(@PathVariable("deviceId") Long deviceId) {
        try {
            connectService.connect(deviceId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @RequestMapping(value = "connect/saveData")
    public ResponseEntity saveData() {
        try {
            connectService.getData(Cache.streamConnection);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}
