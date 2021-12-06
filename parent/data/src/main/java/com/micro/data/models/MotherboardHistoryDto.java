package com.micro.data.models;

import com.micro.data.models.enums.Component;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class MotherboardHistoryDto {
    private Long id;

    private Instant time;

    private List<Component> components;

    private List<Integer> freePorts;
}