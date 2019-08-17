package com.kevin.man.zilch_spending_analyser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "account")
public class AccountModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "account_id", columnDefinition = "BINARY(16)")
    private UUID accountId;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "max_credit")
    private Integer maxCredit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<TransactionModel> transactions;
}
