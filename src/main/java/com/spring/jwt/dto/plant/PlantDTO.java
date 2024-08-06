package com.spring.jwt.dto.plant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PlantDTO {
    @Id
    @GeneratedValue
    private Integer plantId;
    private String name;



    private Double temperature;
    private Double humidity;
    private String growMedium;
    private String nutritions;
    private String containerType;
    private Double plantHeight;
    private String comment;
    private byte[] photo;
    private LocalDateTime dateTime;
    private Integer LUX;
    private Integer PPFD;


}