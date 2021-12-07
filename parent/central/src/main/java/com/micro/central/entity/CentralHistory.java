package com.micro.central.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "central_history")
public class CentralHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private Instant time;

  private Long cpuId;

  private Long discId;

  private Long gpuId;

  private Long motherboardId;

  private long configId;

  private String configName;

}
