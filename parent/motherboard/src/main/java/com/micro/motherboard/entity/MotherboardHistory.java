package com.micro.motherboard.entity;

import com.micro.data.models.enums.Component;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.time.Instant;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Data
@Table(name = "motherboard_history")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class MotherboardHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Instant time = Instant.now();

  @Type(type = "jsonb")
  private List<Component> components;

  @Type(type = "jsonb")
  private List<Component> freePorts;

  private double estimatedPrice;

  private double actualPrice = 0;

  private long configId;

  private String configName;

}
