package com.micro.cpu.entity;


import com.micro.cpu.entity.enums.LoadQuantity;
import com.micro.cpu.entity.enums.LoadSharing;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "cpu_history")
@TypeDef(name = "enum", typeClass = PostgreSQLEnumType.class)
public class CPUHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant time;

    private Boolean overclocking;

    private Double frequency;

    private Double temperature;

    @Enumerated(EnumType.STRING)
    @Type(type = "enum")
    private LoadSharing loadSharing;

    @Enumerated(EnumType.STRING)
    @Type(type = "enum")
    private LoadQuantity loadQuantity;
}