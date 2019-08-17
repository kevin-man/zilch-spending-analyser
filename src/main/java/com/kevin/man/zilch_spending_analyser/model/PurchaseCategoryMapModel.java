package com.kevin.man.zilch_spending_analyser.model;

import com.kevin.man.zilch_spending_analyser.model.enums.PurchaseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "purchase_category")
public class PurchaseCategoryMapModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "purchase_category_map_id", columnDefinition = "BINARY(16)")
    private UUID purchaseCategoryMapId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "purchase_type")
    private PurchaseType purchaseType;

}
