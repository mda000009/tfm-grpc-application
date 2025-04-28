package com.isia.tfm.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.isia.tfm.model.dto.ErrorDetailsDto;
import com.isia.tfm.model.dto.ErrorDetailsErrorDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String VALIDATION_ERROR_MESSAGE = "The request does not meet the validations";

    /**
     * Handles MethodArgumentNotValidException.
     *
     * @param ex the exception
     * @return the response entity with error details
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetailsDto> handleValidationException(MethodArgumentNotValidException ex) {
        return buildErrorResponse(VALIDATION_ERROR_MESSAGE);
    }

    /**
     * Handles ConstraintViolationException.
     *
     * @param ex the exception
     * @return the response entity with error details
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDetailsDto> handleConstraintViolationException(ConstraintViolationException ex) {
        return buildErrorResponse(VALIDATION_ERROR_MESSAGE);
    }

    /**
     * Handles CustomException.
     *
     * @param ex the exception
     * @return the response entity with error details
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetailsDto> handleCustomException(CustomException ex) {
        ErrorDetailsErrorDto errorDetailsError = ex.getErrorDetails().getError();
        HttpStatus status = switch (errorDetailsError.getStatus()) {
            case "400" -> HttpStatus.BAD_REQUEST;
            case "404" -> HttpStatus.NOT_FOUND;
            case "409" -> HttpStatus.CONFLICT;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
        return new ResponseEntity<>(ex.getErrorDetails(), status);
    }

    /**
     * Handles UnrecognizedPropertyException.
     *
     * @param ex the exception
     * @return the response entity with error details
     */
    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ErrorDetailsDto> handleInvalidAttributeName(UnrecognizedPropertyException ex) {
        String message = "Attribute name '" + ex.getPropertyName() + "' is incorrect.";
        return buildErrorResponse(message);
    }

    private ResponseEntity<ErrorDetailsDto> buildErrorResponse(String message) {
        ErrorDetailsErrorDto errorDetails = new ErrorDetailsErrorDto("400", "Bad Request", message);
        ErrorDetailsDto errorResponse = new ErrorDetailsDto(errorDetails);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}