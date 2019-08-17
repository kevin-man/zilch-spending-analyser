package com.kevin.man.zilch_spending_analyser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private UUID accountId;

    @NotNull
    private String accountHolderName;

    @NotNull
    private Integer maxCredit;

    private List<Transaction> transactions;
}
