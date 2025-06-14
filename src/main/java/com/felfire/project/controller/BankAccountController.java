package com.felfire.project.controller;

import com.felfire.project.dto.BankAccountDTO;
import com.felfire.project.dto.BankAccountListDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "BankAccountController", description = "API для управления банковскими счетами")
@RestController
@RequestMapping("/accounts")
public interface BankAccountController {

    @Operation(summary = "Получить объект, состоящий из списка всех банковских счетов, " +
            "а также общего количества денежных на счетах",
            description = "Возвращает BankAccountList")
    @GetMapping
    BankAccountListDTO getAccountsList();

    @Operation(summary = "Открыть банковский счет",
            description = "Открывает банковский счет и возвращает значение открытого банковского счета")
    @GetMapping("/open")
    ResponseEntity<BankAccountDTO> openAccount();

    @Operation(summary = "Закрыть банковский счет",
            description = "Закрывает банковский счет в соответствии с заданным номером",
            parameters = {
                    @Parameter(name = "accountNumber",
                            description = "Номер закрываемого счета")})
    @PostMapping("/close")
    ResponseEntity<Void> closeAccount(@RequestParam("accountNumber") Integer accountNumber);


}
