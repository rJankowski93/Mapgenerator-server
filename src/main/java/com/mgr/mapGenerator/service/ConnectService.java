package com.mgr.mapGenerator.service;

import javax.microedition.io.StreamConnection;
import java.io.IOException;

public interface ConnectService {

    void connect(Long deviceId) throws Exception ;

    void getData(StreamConnection streamConnection) throws IOException;
}
