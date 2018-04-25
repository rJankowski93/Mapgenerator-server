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

    //TODO w kliencie zmienic zeby wysylal deviceName w POST i zmienic mapping na refreshData
    @RequestMapping(path = "/refreshData", method = RequestMethod.POST, produces = "application/json")
    public void refreshData(String deviceName) {
        encoderService.refreshData(deviceName);
    }

    @RequestMapping(path = "/encoderData/{selectedDevice}", method = RequestMethod.GET)
    public List<EncoderData> getEncoderData(@PathVariable String selectedDevice) {
        return encoderService.getEncoderDataByDeviceName(selectedDevice);
    }

}
