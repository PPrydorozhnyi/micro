package com.micro.motherboard.entity;

import com.micro.motherboard.entity.enums.Component;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Type(type = "jsonb")
    private List<Component> components;

    @Type(type = "jsonb")
    private List<Integer> freePorts;
}