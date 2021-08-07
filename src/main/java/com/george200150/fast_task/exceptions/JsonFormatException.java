package com.george200150.fast_task.exceptions;

public class JsonFormatException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public JsonFormatException() { }
    public JsonFormatException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) { super(message, cause,
            enableSuppression, writableStackTrace); }
    public JsonFormatException(String message, Throwable cause) { super(message, cause); }
    public JsonFormatException(String message) { super(message); }
    public JsonFormatException(Throwable cause) { super(cause); }
}
