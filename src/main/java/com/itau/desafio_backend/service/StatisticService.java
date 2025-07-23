package com.itau.desafio_backend.service;

import com.itau.desafio_backend.dto.StatisticResponse;
import com.itau.desafio_backend.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
public class StatisticService {

    private final TransactionService transactionService;

    public StatisticService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public StatisticResponse createStatistic() {
        DoubleSummaryStatistics statistics = transactionService.getTransactions()
                .stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
        return new StatisticResponse(statistics);
    }
}
