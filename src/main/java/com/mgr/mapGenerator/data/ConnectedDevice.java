package com.mgr.mapGenerator.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.microedition.io.StreamConnection;

@Getter
@AllArgsConstructor
public class ConnectedDevice {
    final private String deviceName;
    final private StreamConnection streamConnection;
    final private Double distanceBetweenWheels;
}
