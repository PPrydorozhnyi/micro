package com.micro.cpu.entity;


import com.micro.cpu.entity.enums.LoadQuantity;
import com.micro.cpu.entity.enums.LoadSharing;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class CPU {

    @Id
    private Long id;

    private String name;

    private Boolean overclocking;

    private Double frequency;

    private Double temperature;

    private LoadSharing loadSharing;

    private LoadQuantity loadQuantity;
}