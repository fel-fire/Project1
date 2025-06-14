package com.felfire.project.exception;


/**
 * Исключение, свидетельствующее о некорректном состоянии банковского счета при совершении операций с ним
 */
public class InvalidScoreValue extends RuntimeException {
    public InvalidScoreValue(String message) {
        super(message);
    }
}
