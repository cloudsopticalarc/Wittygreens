package com.spring.jwt.dto;

import jakarta.persistence.SecondaryTable;
import lombok.Data;

@Data
public class ResponseLoginDto {
    public String message;
    public Object token;
    public Boolean hasError;



}
