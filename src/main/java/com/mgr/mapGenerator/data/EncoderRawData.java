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

    public EncoderRawData(Long left, Long right) {
        this.left = left;
        this.right = right;
    }
}
