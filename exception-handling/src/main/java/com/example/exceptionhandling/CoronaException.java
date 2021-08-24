package com.example.exceptionhandling;

public class CoronaException extends RuntimeException {
    public CoronaException(String s) {
        super(s);
    }
}
