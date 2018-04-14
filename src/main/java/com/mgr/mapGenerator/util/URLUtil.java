package com.mgr.mapGenerator.util;

import javax.bluetooth.RemoteDevice;

public class URLUtil {

    public static String createDeviceUrl(RemoteDevice remoteDevice) {
        return "btspp://" + remoteDevice.getBluetoothAddress() + ":1;authenticate=false;encrypt=false;master=false";
    }
}
