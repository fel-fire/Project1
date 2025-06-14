package com.felfire.project.service.impl;

import com.felfire.project.annotation.Mutator;
import com.felfire.project.annotation.MyCache;
import com.felfire.project.dto.TransferDTO;
import com.felfire.project.entity.Transfer;
import com.felfire.project.mapper.TransferMapper;
import com.felfire.project.repository.TransferRepo;
import com.felfire.project.service.BankAccountService;
import com.felfire.project.service.LoggedUserManagementService;
import com.felfire.project.service.TransferHistorySaverService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@MyCache("getHistory")
@NoArgsConstructor
public class TransferHistorySaverServiceImpl implements TransferHistorySaverService {
    private TransferRepo transferRepo;
    private LoggedUserManagementService loggedUserManagementService;
    private TransferMapper transferMapper;
    private BankAccountService bankAccountService;

    @Autowired
    public TransferHistorySaverServiceImpl(TransferRepo transferRepo,
                                           LoggedUserManagementService loggedUserManagementService,
                                           TransferMapper transferMapper,
                                           BankAccountService bankAccountService) {
        this.transferRepo = transferRepo;
        this.loggedUserManagementService = loggedUserManagementService;
        this.transferMapper = transferMapper;
        this.bankAccountService = bankAccountService;
    }

    @Override
    public List<TransferDTO> getHistory() {
        List<TransferDTO> list = new ArrayList<>();
        transferRepo.findAllByOwner(loggedUserManagementService.getId())
                .forEach(x -> list.add(transferMapper.toDTO(x)));
        return list;
    }

    @Override
    @Mutator
    public void saveInHistory(Transfer transfer) {
            transferRepo.save(transfer);
            bankAccountService.reset();
    }

    @Override
    @Mutator
    public void reset() {
    }
}
