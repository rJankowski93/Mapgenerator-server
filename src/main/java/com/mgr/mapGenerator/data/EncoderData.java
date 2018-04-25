package com.mgr.mapGenerator.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENCODER_DATA")
public class EncoderData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DEGREES")
    private Double degrees;

    @Column(name = "DISTANCE")
    private Double distance;

    @Column(name = "RAW_DATA_ID")
    private Long rawDataId;

    @Column(name = "DEVICE_NAME")
    private String deviceName;

    public EncoderData(Long id) {
        this.id=id;
    }
}
