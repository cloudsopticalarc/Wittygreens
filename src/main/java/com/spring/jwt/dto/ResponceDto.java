package com.spring.jwt.dto;


import lombok.Data;

@Data
public class ResponceDto {
    public String message;
    public Object object;
    public Boolean hasError;


    public ResponceDto(String message, Object object,Boolean hasError) {
        this.message = message;
        this.object = object;
        this.hasError=hasError;
    }



}
