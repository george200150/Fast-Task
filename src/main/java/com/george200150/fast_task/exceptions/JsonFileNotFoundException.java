package com.george200150.fast_task.exceptions;

public class JsonFileNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2L;

    public JsonFileNotFoundException() { }
    public JsonFileNotFoundException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) { super(message, cause,
            enableSuppression, writableStackTrace); }
    public JsonFileNotFoundException(String message, Throwable cause) { super(message, cause); }
    public JsonFileNotFoundException(String message) { super(message); }
    public JsonFileNotFoundException(Throwable cause) { super(cause); }
}
