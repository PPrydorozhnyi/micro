package com.micro.motherboard.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

@Entity
@Data
@Table(name = "motherboard_config")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class MotherboardConfig {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private boolean components;

  private boolean freePorts;

}
