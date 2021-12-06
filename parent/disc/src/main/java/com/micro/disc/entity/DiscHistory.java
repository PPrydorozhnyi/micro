package com.micro.disc.entity;

import com.micro.disc.entity.enums.Integrity;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "disc_history")
@TypeDef(name = "enum", typeClass = PostgreSQLEnumType.class)
public class DiscHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant time;

    private Double speed;

    private Double temperature;

    @Enumerated(EnumType.STRING)
    @Type(type = "enum")
    private Integrity integrity;
}
