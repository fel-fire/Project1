package com.felfire.project.controller;

import com.felfire.project.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CustomerController", description = "API для управления клиентами банка")
@RestController
@RequestMapping("/office")
public interface CustomerController {

    @Operation(summary = "Получить данные о текущем клиенте",
            description = "Возвращает данные текущем пользователе личным кабинетом")
    @GetMapping("/current")
    CustomerDTO getCurrent();


    @Operation(summary = "Зарегистрировать нового клиента в системе",
            description = "Регистрирует нового клиента в системе банка в соответствии с заполненной формой",
            parameters = {
                    @Parameter(name = "dto",
                            description = "Сведения о  пользователе в соответствии с формой")})
    @PostMapping
    ResponseEntity<?> register(@Valid @RequestBody CustomerDTO dto);


    @Operation(summary = "Получить данные о клиенте по номеру паспорта",
            description = "Возвращает данные о клиенте банка по номеру паспорта")
    @GetMapping
    CustomerDTO getByPassport(@NotBlank @RequestParam String passport);


    @Operation(summary = "Удалить сведения о клиенте из системы",
            description = "Удаляет сведения о клиенте банка из системы по ID клиента")
    @DeleteMapping("/{id}")
    void delete(@Min(1) @PathVariable Integer id);


    @Operation(summary = "Обновить сведения о клиенте в системе",
            description = "Обновляет сведения о клиенте в системе банка в соответствии с заполненной формой",
            parameters = {
                    @Parameter(name = "dto",
                            description = "Сведения о пользователе в соответствии с формой")})
    @PatchMapping
    ResponseEntity<?> update(@Valid @RequestBody CustomerDTO dto);

}
