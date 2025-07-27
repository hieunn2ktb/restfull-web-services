package com.example.rest.webservices.restfull_web_services.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDrtails {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorDrtails(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
