package com.mgr.mapGenerator.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends Exception{
    public ApplicationException(ApplicationExceptionCodes exception) {
        super(exception.getMessage());
        this.httpStatus = exception.getHttpStatus();
    }

    private HttpStatus httpStatus;
}
