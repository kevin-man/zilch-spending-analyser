package com.kevin.man.zilch_spending_analyser.repo;

import com.kevin.man.zilch_spending_analyser.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountModel, UUID> {

}
