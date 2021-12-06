package com.micro.gpu.entity;

import com.micro.gpu.entity.enums.FanOperatingMode;
import com.micro.gpu.entity.enums.LoadQuantity;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "gpu_history")
@TypeDef(name = "enum", typeClass = PostgreSQLEnumType.class)
public class GPUHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant time;

    private Double temperature;

    @Enumerated(EnumType.STRING)
    @Type(type = "enum")
    private FanOperatingMode fanOperatingMode;

    @Enumerated(EnumType.STRING)
    @Type(type = "enum")
    private LoadQuantity loadQuantity;
}
