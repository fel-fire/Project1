package com.felfire.project.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Сервис для управления банковскими транзакциями. Предоставляет возможность осуществить банковскую транзакцию
 * на основании номеров счетов отправления и назначения, а также суммы денежных средств.
 */
@Service
public interface TransferService {

    void transfer(Integer from, Integer to, Double amount);

}
