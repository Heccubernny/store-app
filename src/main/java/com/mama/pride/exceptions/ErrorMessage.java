package com.mama.pride.exceptions;

import java.util.Date;

public class ErrorMessage {
    private int statusCode;

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    private Date timestamp;

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    private String description;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

}
