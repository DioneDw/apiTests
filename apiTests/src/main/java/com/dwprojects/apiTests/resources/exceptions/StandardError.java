package com.dwprojects.apiTests.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter

public class StandardError {
    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;

    public StandardError(LocalDateTime timeStamp, Integer status, String error, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }
}
