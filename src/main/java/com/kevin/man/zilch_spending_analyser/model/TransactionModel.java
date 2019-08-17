package com.kevin.man.zilch_spending_analyser.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transaction")
public class TransactionModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "transaction_id", columnDefinition = "BINARY(16)")
    private UUID transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    private AccountModel account;

    @Column(name = "company")
    private String company;

    @Column(name = "price")
    private BigDecimal price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private LocalDate date;

}
