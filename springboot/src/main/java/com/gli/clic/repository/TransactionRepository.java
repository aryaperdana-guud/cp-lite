package com.gli.clic.repository;

import com.gli.clic.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.txnNode = :txnNode AND t.txnType = :txnType")
    List<Transaction> findByTxnNodeAndTxnType(@Param("txnNode") String txnNode, @Param("txnType") String txnType);

    @Query("SELECT t FROM Transaction t WHERE t.txnType = :txnType")
    List<Transaction> findByTxnType(@Param("txnType") String txnType);

    @Query("SELECT t FROM Transaction t WHERE t.txnNode = :txnNode")
    List<Transaction> findByTxnNode(@Param("txnNode") String txnNode);
}
