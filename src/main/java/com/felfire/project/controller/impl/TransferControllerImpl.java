package com.felfire.project.controller.impl;

import com.felfire.project.controller.TransferController;
import com.felfire.project.dto.TransferDTO;
import com.felfire.project.service.TransferHistorySaverService;
import com.felfire.project.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransferControllerImpl implements TransferController {
    private final TransferService transferService;
    private final TransferHistorySaverService transferHistorySaverService;

    @Override
    public List<TransferDTO> getHistory() {
        return transferHistorySaverService.getHistory();
    }

    @Override
    public void transfer(Integer from, Integer to, Double amount) {
        transferService.transfer(from, to, amount);
    }
}
