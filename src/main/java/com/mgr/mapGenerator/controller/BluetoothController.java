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

}
