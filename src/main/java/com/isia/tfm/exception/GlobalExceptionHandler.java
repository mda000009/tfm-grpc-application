package com.isia.tfm.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.isia.tfm.model.dto.ErrorDetailsErrorDto;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GlobalExceptionHandler {

    private static final String VALIDATION_ERROR_MESSAGE = "The request does not meet the validations";

    /**
     * Maneja MethodArgumentNotValidException.
     *
     * @param ex la excepción
     * @param responseObserver el observador de respuesta de gRPC
     */
    public void handleValidationException(MethodArgumentNotValidException ex, StreamObserver<?> responseObserver) {
        handleGrpcError(Status.INVALID_ARGUMENT.withDescription(VALIDATION_ERROR_MESSAGE), responseObserver);
    }

    /**
     * Maneja ConstraintViolationException.
     *
     * @param ex la excepción
     * @param responseObserver el observador de respuesta de gRPC
     */
    public void handleConstraintViolationException(ConstraintViolationException ex, StreamObserver<?> responseObserver) {
        handleGrpcError(Status.INVALID_ARGUMENT.withDescription(VALIDATION_ERROR_MESSAGE), responseObserver);
    }

    /**
     * Maneja CustomException.
     *
     * @param ex la excepción
     * @param responseObserver el observador de respuesta de gRPC
     */
    public void handleCustomException(CustomException ex, StreamObserver<?> responseObserver) {
        ErrorDetailsErrorDto errorDetailsError = ex.getErrorDetails().getError();
        Status status = switch (errorDetailsError.getStatus()) {
            case "3" -> Status.INVALID_ARGUMENT.withDescription(errorDetailsError.getMessage());
            case "5" -> Status.NOT_FOUND.withDescription(errorDetailsError.getMessage());
            case "6" -> Status.ALREADY_EXISTS.withDescription(errorDetailsError.getMessage());
            default -> Status.INTERNAL.withDescription(errorDetailsError.getMessage());
        };
        handleGrpcError(status, responseObserver);
    }

    /**
     * Maneja UnrecognizedPropertyException.
     *
     * @param ex la excepción
     * @param responseObserver el observador de respuesta de gRPC
     */
    public void handleInvalidAttributeName(UnrecognizedPropertyException ex, StreamObserver<?> responseObserver) {
        String message = "Attribute name '" + ex.getPropertyName() + "' is incorrect.";
        handleGrpcError(Status.INVALID_ARGUMENT.withDescription(message), responseObserver);
    }

    /**
     *
     * @param status el estado de gRPC
     * @param responseObserver el observador de respuesta de gRPC
     */
    private void handleGrpcError(Status status, StreamObserver<?> responseObserver) {
        responseObserver.onError(status.asRuntimeException());
    }
}