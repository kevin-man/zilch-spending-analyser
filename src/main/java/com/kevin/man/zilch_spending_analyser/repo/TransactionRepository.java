package com.kevin.man.zilch_spending_analyser.repo;

import com.kevin.man.zilch_spending_analyser.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
}
