package com.gli.clic.service;

import com.gli.clic.model.Transaction;
import com.gli.clic.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> filterTransactions(String txnNode, String txnType) {
        if (txnNode != null && txnType != null) {
            return transactionRepository.findByTxnNodeAndTxnType(txnNode, txnType);
        } else if (txnNode != null) {
            return transactionRepository.findByTxnNode(txnNode);
        } else if (txnType != null) {
            return transactionRepository.findByTxnType(txnType);
        }
        return transactionRepository.findAll();
    }
    
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
