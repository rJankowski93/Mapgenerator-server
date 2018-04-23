package com.mgr.mapGenerator.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ApplicationExceptionCodes {

    CONNECTION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR,"Connection with device failed."),
    DEVICE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR,"Device not found");

    private final HttpStatus httpStatus;

    private final String message;
}
