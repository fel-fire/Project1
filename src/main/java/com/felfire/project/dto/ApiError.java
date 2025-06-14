package com.felfire.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO для передачи сведений об ошибке (исключении)
 */

@Data
@AllArgsConstructor
public class ApiError {
    private int statusCode;
    private String message;
}
