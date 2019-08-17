package com.kevin.man.zilch_spending_analyser.mapper;

import com.kevin.man.zilch_spending_analyser.dto.Account;
import com.kevin.man.zilch_spending_analyser.dto.PurchaseCategoryMap;
import com.kevin.man.zilch_spending_analyser.dto.Transaction;
import com.kevin.man.zilch_spending_analyser.model.AccountModel;
import com.kevin.man.zilch_spending_analyser.model.PurchaseCategoryMapModel;
import com.kevin.man.zilch_spending_analyser.model.TransactionModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountModel toAccountModel(Account account);

    Account toAccount(AccountModel accountModel);

    TransactionModel toTransactionModel(Transaction transaction);

    Transaction toTransaction(TransactionModel transactionModel);

    List<Account> toAccounts(List<AccountModel> accountModels);

    PurchaseCategoryMap toPurchaseCategoryMap(PurchaseCategoryMapModel purchaseCategoryMapModel);

    PurchaseCategoryMapModel toPurchaseCCategoryMapModel(PurchaseCategoryMap purchaseCategoryMap);

    List<PurchaseCategoryMap> toPurchaseCategoryMaps(List<PurchaseCategoryMapModel> purchaseCategoryMapModels);
}
