package com.mgr.linefollower;

import com.mgr.mapGenerator.MapGeneratorServerApplication;
import com.mgr.mapGenerator.controller.DeviceController;
import com.mgr.mapGenerator.controller.MapController;
import com.mgr.mapGenerator.repository.DeviceRepository;
import com.mgr.mapGenerator.repository.EncoderDataRepository;
import com.mgr.mapGenerator.repository.EncoderRawDataRepository;
import com.mgr.mapGenerator.service.ConnectService;
import com.mgr.mapGenerator.service.DeviceService;
import com.mgr.mapGenerator.service.EncoderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapGeneratorServerApplication.class)
public class MapGeneratorServerApplicationTests {

	@Autowired
	private ConnectService connectService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private EncoderService encoderService;

	@Autowired
	private DeviceController deviceController;
	@Autowired
	private MapController mapController;

	@Autowired
	private DeviceRepository deviceRepository;
	@Autowired
	private EncoderDataRepository encoderDataRepository;
	@Autowired
	private EncoderRawDataRepository encoderRawDataRepository;

	@Test
	public void contextLoads() {
		assertThat(connectService).isNotNull();
		assertThat(deviceService).isNotNull();
		assertThat(encoderService).isNotNull();

		assertThat(deviceController).isNotNull();
		assertThat(mapController).isNotNull();

		assertThat(deviceRepository).isNotNull();
		assertThat(encoderDataRepository).isNotNull();
		assertThat(encoderRawDataRepository).isNotNull();
	}


}
