package com.mgr.mapGenerator.data;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ENCODER_RAW_DATA")
public class EncoderRawData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LEFT")
    private Long left;

    @Column(name = "RIGHT")
    private Long right;

    @Column(name = "SENSOR")
    private Double sensor;

    @Column(name = "DEVICE_NAME")
    private String deviceName;

    public EncoderRawData(Long left, Long right, Double sensor, String deviceName) {
        this.left = left;
        this.right = right;
        this.sensor = sensor;
        this.deviceName = deviceName;

    }

    public Double calculateDifferenceTraveledDistance() {
        return Double.valueOf(getLeft()) - Double.valueOf(getRight());
    }
}
