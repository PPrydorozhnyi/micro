package com.micro.gpu.entity;

import com.micro.gpu.entity.enums.FanOperatingMode;
import com.micro.gpu.entity.enums.LoadQuantity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class GPU {
    @Id
    private Long id;

    private String name;

    private Double temperature;

    private FanOperatingMode fanOperatingMode;

    private LoadQuantity loadQuantity;
}
