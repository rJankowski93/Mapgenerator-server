package com.mgr.mapGenerator.controller;

import com.mgr.mapGenerator.data.Cache;
import com.mgr.mapGenerator.service.ConnectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/connect")
@RequiredArgsConstructor
public class BluetoothController {

    private final ConnectService connectService;

    @RequestMapping("/{deviceId}")
    public ResponseEntity connect(@PathVariable("deviceId") Long deviceId) {
        try {
            connectService.connect(deviceId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @RequestMapping(value = "/saveData")
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
