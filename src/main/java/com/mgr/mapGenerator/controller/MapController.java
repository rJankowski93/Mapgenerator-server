package com.mgr.mapGenerator.controller;

import com.mgr.mapGenerator.data.EncoderData;
import com.mgr.mapGenerator.service.EncoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/encoderData", method = RequestMethod.GET, produces = "application/json")
    public List<EncoderData> getEncoderData() {
        return encoderService.getAll();
    }

}
