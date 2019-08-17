package com.kevin.man.zilch_spending_analyser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccount {

    @NotNull
    private String accountHolderName;

    @NotNull
    private Integer maxCredit;

}
