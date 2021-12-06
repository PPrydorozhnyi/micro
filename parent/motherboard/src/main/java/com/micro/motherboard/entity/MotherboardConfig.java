package com.micro.motherboard.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Data
@Table(name = "motherboard_config")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class MotherboardConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean components;

    private Boolean freePorts;
}