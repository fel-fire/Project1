package com.felfire.project.exceptionhandler;

import com.felfire.project.dto.ApiError;
import com.felfire.project.exception.InvalidScoreValue;
import com.felfire.project.exception.NoSuchEntityFound;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Обработчик исключений
 */
@RestControllerAdvice
public class ExceptHandler {

    @ExceptionHandler(NoSuchEntityFound.class)
    public ApiError handleNoSuchEntityFoundExceptions(Throwable ex) {
        return new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler({InvalidScoreValue.class,
            DataIntegrityViolationException.class,
            MethodArgumentNotValidException.class})
    public ApiError handleInvalidScoreValueExceptions(Throwable ex) {
        return new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
