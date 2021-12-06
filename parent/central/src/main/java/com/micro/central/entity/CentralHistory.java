package com.micro.central.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "central_history")
public class CentralHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant time;

    private Long cpuId;

    private Long discId;

    private Long gpuId;

    private Long motherboardId;
}