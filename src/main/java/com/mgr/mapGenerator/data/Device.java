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
@Table(name = "DEVICE")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    @Column(name = "BT_ADDRESS")
    private String btAddress;

    @Column(name = "DISTANCE_BETWEEN_WHEELS")
    private Double distanceBetweenWheels;

    public Device(String name, String btAddress, String url) {
        this.name = name;
        this.url = url;
        this.btAddress = btAddress;
    }
}
