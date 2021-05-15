package com.hussam.movieservice.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionResponse {
    private int status;
    private String error;
    private String message;
    private Date timestamp;

    public ExceptionResponse(Date timestamp, int status,String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;


    }
}
