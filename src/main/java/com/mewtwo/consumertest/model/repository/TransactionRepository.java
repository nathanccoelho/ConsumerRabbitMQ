package com.mewtwo.consumertest.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mewtwo.consumertest.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{

}
