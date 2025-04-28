package com.isia.tfm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetailsErrorDto {

    private String status;
    private String description;
    private String message;

}
