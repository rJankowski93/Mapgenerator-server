package com.mgr.mapGenerator.service;

import com.mgr.mapGenerator.data.ConnectedDevice;
import com.mgr.mapGenerator.exceptions.ApplicationException;

import javax.microedition.io.StreamConnection;
import java.io.IOException;
import java.util.Optional;

public interface ConnectService {

    void connect(Long deviceId) throws ApplicationException;

    void getData(ConnectedDevice connectedDevice) throws IOException;


}
