package com.urlshortner.exception;

public class SystemExceptionWithUserMessage extends RuntimeException{
    public SystemExceptionWithUserMessage() {
        super();
    }

    public SystemExceptionWithUserMessage(String message) {
        super(message);
    }
}