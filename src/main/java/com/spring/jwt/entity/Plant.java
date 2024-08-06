package com.spring.jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Plant {
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

    public void setName(String name) {
        if (name != null) {
            this.name = name.toLowerCase();
        } else {
            this.name = null;
        }
    }

    public void setGrowMedium(String growMedium) {
        if (growMedium != null) {
            this.growMedium = growMedium.toLowerCase();
        } else {
            this.growMedium = null;
        }
    }

    public void setNutritions(String nutritions) {
        if (nutritions != null) {
            this.nutritions = nutritions.toLowerCase();
        } else {
            this.nutritions = null;
        }
    }

    public void setContainerType(String containerType) {
        if (containerType != null) {
            this.containerType = containerType.toLowerCase();
        } else {
            this.containerType = null;
        }
    }

    public void setComment(String comment) {
        if (comment != null) {
            this.comment = comment.toLowerCase();
        } else {
            this.comment = null;
        }
    }


}