package com.micro.gpu.entity;

import com.micro.data.models.enums.FanOperatingMode;
import com.micro.data.models.enums.LoadQuantity;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Data
@Table(name = "gpu_history")
@TypeDef(name = "enum", typeClass = PostgreSQLEnumType.class)
public class GPUHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Instant time = Instant.now();

  private Double temperature;

  @Enumerated(EnumType.STRING)
  @Type(type = "enum")
  private FanOperatingMode fanOperatingMode;

  @Enumerated(EnumType.STRING)
  @Type(type = "enum")
  private LoadQuantity loadQuantity;

  private double estimatedPrice;

  private double actualPrice = 0;

  private long configId;

  private String configName;

}
