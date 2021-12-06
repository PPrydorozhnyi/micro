package com.micro.cpu.entity;


import com.micro.cpu.entity.enums.LoadQuantity;
import com.micro.cpu.entity.enums.LoadSharing;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "cpu_history")
public class CPUHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant time;

    private Boolean overclocking;

    private Double frequency;

    private Double temperature;

    private LoadSharing loadSharing;

    private LoadQuantity loadQuantity;
}