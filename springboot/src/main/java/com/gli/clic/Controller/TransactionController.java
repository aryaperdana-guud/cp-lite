package com.gli.clic.Controller; 

import com.gli.clic.model.Transaction;
import com.gli.clic.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() { 
        return transactionService.getAllTransactions();
    }
    
    @GetMapping("/filter")
    public List<Transaction> filterTransactions(
            @RequestParam(required = false) String txnNode,
            @RequestParam(required = false) String txnType) {
        return transactionService.filterTransactions(txnNode, txnType);
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getTransactionById(@PathVariable Long id) { 
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
