package com.micro.motherboard.entity;

import com.micro.motherboard.entity.enums.Component;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Table(name = "motherboard_history")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class MotherboardHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant time;

    @Type(type = "jsonb")
    private List<Component> components;

    @Type(type = "jsonb")
    private List<Integer> freePorts;
}