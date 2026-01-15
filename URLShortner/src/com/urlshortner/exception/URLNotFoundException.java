package com.urlshortner.exception;

public class URLNotFoundException extends RuntimeException{
    public URLNotFoundException() {
        super();
    }

    public URLNotFoundException(String message) {
        super(message);
    }
}