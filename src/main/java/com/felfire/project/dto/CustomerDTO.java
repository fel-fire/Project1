package com.felfire.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DTO для передачи данных о пользователе
 */
@Data
public class CustomerDTO {
    private Integer id;
    @NotBlank
    private String lastname;
    @NotBlank
    private String firstname;
    private String patronimyc;
    private String town;
    @NotBlank
    private String passport;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
