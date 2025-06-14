package com.felfire.project.exception;

/**
 * Исключение, свидетельствующее об отсутствии в базе данных сведений о запрашиваемом объекте
 */
public class NoSuchEntityFound extends RuntimeException{

    public NoSuchEntityFound(String message) {
        super(message);
    }
}
