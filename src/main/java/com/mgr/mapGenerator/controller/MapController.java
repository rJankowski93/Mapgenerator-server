package com.mgr.mapGenerator.controller;

import com.mgr.mapGenerator.data.EncoderData;
import com.mgr.mapGenerator.service.EncoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final EncoderService encoderService;

    @RequestMapping(path = "/generateData", method = RequestMethod.POST, produces = "application/json")
    public void generateData() {
        encoderService.generateData();
    }

    @RequestMapping(path = "/encoderData/{selectedDevice}", method = RequestMethod.GET)
    public List<EncoderData> getEncoderData(@PathVariable String selectedDevice) {
        return encoderService.getEncoderDataByDeviceName(selectedDevice);
    }

}
