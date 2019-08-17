package com.kevin.man.zilch_spending_analyser.repo;

import com.kevin.man.zilch_spending_analyser.model.PurchaseCategoryMapModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PurchaseCategoryMapRepository extends JpaRepository<PurchaseCategoryMapModel, UUID> {

    Optional<PurchaseCategoryMapModel> findPurchaseCategoryMapRepositoriesByCompanyName(String companyName);

}
