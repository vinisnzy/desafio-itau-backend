package com.itau.desafio_backend.service;

import com.itau.desafio_backend.dto.TransactionRequest;
import com.itau.desafio_backend.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void createTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction(request.valor(), request.dataHora());
        transactions.add(transaction);
    }
}
