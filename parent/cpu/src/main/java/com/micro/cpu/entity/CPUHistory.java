package com.micro.cpu.entity;

import com.micro.data.models.enums.LoadQuantity;
import com.micro.data.models.enums.LoadSharing;
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
@Table(name = "cpu_history")
@TypeDef(name = "enum", typeClass = PostgreSQLEnumType.class)
public class CPUHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private Instant time = Instant.now();

  private Boolean overclocking;

  private Double frequency;

  private Double temperature;

  @Enumerated(EnumType.STRING)
  @Type(type = "enum")
  private LoadSharing loadSharing;

  @Enumerated(EnumType.STRING)
  @Type(type = "enum")
  private LoadQuantity loadQuantity;

  private double estimatedPrice;

  private double actualPrice = 0;

}
