package com.micro.cpu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cpu_config")
public class CPUConfig {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  private boolean overclocking;

  private boolean frequency;

  private boolean temperature;

  private boolean loadSharing;

  private boolean loadQuantity;

}
