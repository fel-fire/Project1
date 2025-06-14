package com.felfire.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "LoginController", description = "API для управления авторизацией в личном кабинете")
@Controller
@RequestMapping("/login")
public interface LoginController {

    @Operation(summary = "Войти в личный кабинет",
            description = "Осуществляет перенаправление пользователя в личный кабинет в случае, " +
                    "если введенные имя пользователя и пароль зарегистрированы в системе",
            parameters = {
                    @Parameter(name = "username",
                            description = "Имя пользователя"),
                    @Parameter(name = "password",
                            description = "Пароль")})
    @PostMapping
    ResponseEntity<String> loginPost(@NotBlank @RequestParam("username") String username,
                                     @NotBlank @RequestParam("password") String password);


    @Operation(summary = "Завершить сеанс и выйти из личного кабинета",
            description = "Осуществляет выход из личного кабинета")
    @GetMapping
    ResponseEntity<Void> logout();

}
