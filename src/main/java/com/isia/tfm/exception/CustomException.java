package com.isia.tfm.exception;

import com.isia.tfm.model.dto.ErrorDetailsDto;
import com.isia.tfm.model.dto.ErrorDetailsErrorDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

    private final transient ErrorDetailsDto errorDetails;

    public CustomException(String status, String description, String message) {
        ErrorDetailsErrorDto errorDetailsError = new ErrorDetailsErrorDto(status, description, message);
        this.errorDetails = new ErrorDetailsDto(errorDetailsError);
    }

}

