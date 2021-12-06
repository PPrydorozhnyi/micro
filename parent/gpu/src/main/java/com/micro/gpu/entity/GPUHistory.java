package com.micro.gpu.entity;

import com.micro.gpu.entity.enums.FanOperatingMode;
import com.micro.gpu.entity.enums.LoadQuantity;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "gpu_history")
public class GPUHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant time;

    private Double temperature;

    private FanOperatingMode fanOperatingMode;

    private LoadQuantity loadQuantity;
}
