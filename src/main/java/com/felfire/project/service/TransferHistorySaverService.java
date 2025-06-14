package com.felfire.project.service;

import com.felfire.project.dto.TransferDTO;
import com.felfire.project.entity.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для управления историей совершенных транзакций. Предоставляет возможность получить
 * список совершенных банковских транзакций, а также сохранить транзакцию в историю.
 */
@Service

public interface TransferHistorySaverService {

    List<TransferDTO> getHistory();

    void saveInHistory(Transfer transfer);

    void reset();
}
