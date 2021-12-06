package com.micro.disc.entity;

import com.micro.disc.entity.enums.Integrity;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "disc_history")
public class DiscHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant time;

    private Double speed;

    private Double temperature;

    private Integrity integrity;
}
