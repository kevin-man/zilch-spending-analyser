package com.kevin.man.zilch_spending_analyser.dto;

import com.kevin.man.zilch_spending_analyser.model.enums.PurchaseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseCategoryMap {

    @NotNull
    private String companyName;

    @NotNull
    private PurchaseType purchaseType;

}
