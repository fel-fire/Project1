package com.felfire.project.controller;


import com.felfire.project.dto.TransferDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "TransferController", description = "API для управления банковскими транзакциями")
@RequestMapping("/transfer")
public interface TransferController {

    @Operation(summary = "Получить историю банковских транзакций",
            description = "Возвращает список совершенных банковских транзакций")
    @GetMapping("/history")
    List<TransferDTO> getHistory();

    @Operation(summary = "Выполнить банковскую транзакцию",
            description = "Выполняет перевод денежных средств со счета FROM на счет TO в количестве, " +
                    "указанном в значении AMOUNT",
            parameters = {
                    @Parameter(name = "from",
                            description = "Номер счета отправления"),
                    @Parameter(name = "to",
                            description = "Номер счета назначения"),
                    @Parameter(name = "amount",
                            description = "Сумма")})
    @PostMapping
    void transfer(@NotNull @RequestParam("from") Integer from,
                  @NotNull @RequestParam("to") Integer to,
                  @PositiveOrZero @RequestParam("amount") Double amount);
}

