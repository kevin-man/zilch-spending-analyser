package com.kevin.man.zilch_spending_analyser.service;

import com.kevin.man.zilch_spending_analyser.dto.Account;
import com.kevin.man.zilch_spending_analyser.dto.CreateAccount;
import com.kevin.man.zilch_spending_analyser.dto.PurchaseCategoryMap;
import com.kevin.man.zilch_spending_analyser.exception.NotFoundException;
import com.kevin.man.zilch_spending_analyser.mapper.AccountMapper;
import com.kevin.man.zilch_spending_analyser.model.AccountModel;
import com.kevin.man.zilch_spending_analyser.model.PurchaseCategoryMapModel;
import com.kevin.man.zilch_spending_analyser.model.enums.PurchaseType;
import com.kevin.man.zilch_spending_analyser.repo.AccountRepository;
import com.kevin.man.zilch_spending_analyser.repo.PurchaseCategoryMapRepository;
import com.kevin.man.zilch_spending_analyser.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ZilchSpendingAnalyserService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private PurchaseCategoryMapRepository purchaseCategoryMapRepository;
    private AccountMapper accountMapper;

    @Autowired
    public ZilchSpendingAnalyserService(AccountRepository accountRepository,
                                        TransactionRepository transactionRepository,
                                        PurchaseCategoryMapRepository purchaseCategoryMapRepository,
                                        AccountMapper accountMapper) {

        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.purchaseCategoryMapRepository = purchaseCategoryMapRepository;
        this.accountMapper = accountMapper;
    }

    public List<Account> getAccounts() {
        List<AccountModel> accountModels = accountRepository.findAll();

        if (accountModels.isEmpty()) {
            return new ArrayList<>();
        }

        return accountMapper.toAccounts(accountModels);
    }

    public Account createAccount(final CreateAccount createAccount) {
        Account account = Account.builder()
                .accountHolderName(createAccount.getAccountHolderName())
                .maxCredit(createAccount.getMaxCredit())
                .build();

        AccountModel accountModel = accountRepository.saveAndFlush(accountMapper.toAccountModel(account));
        return accountMapper.toAccount(accountModel);
    }

    public Account getTransactions(final UUID accountId) {
        AccountModel accountModel = accountRepository.findById(accountId).orElseThrow(() ->
                new NotFoundException("Account was not Found"));

        return accountMapper.toAccount(accountModel);
    }

    public List<PurchaseCategoryMap> getPurchaseCategoryMaps() {
        List<PurchaseCategoryMapModel> purchaseCategoryMapModels = purchaseCategoryMapRepository.findAll();

        if (purchaseCategoryMapModels.isEmpty()) {
            return new ArrayList<>();
        }

        return accountMapper.toPurchaseCategoryMaps(purchaseCategoryMapModels);
    }

    public PurchaseCategoryMap createPurchaseCategoryMapping(final PurchaseCategoryMap purchaseCategoryMap) {

        PurchaseCategoryMapModel purchaseCategoryMapModel = PurchaseCategoryMapModel.builder()
                .companyName(purchaseCategoryMap.getCompanyName())
                .purchaseType(purchaseCategoryMap.getPurchaseType())
                .build();

        PurchaseCategoryMapModel savedPurchaseCategoryModel = purchaseCategoryMapRepository
                .saveAndFlush(purchaseCategoryMapModel);

        return accountMapper.toPurchaseCategoryMap(savedPurchaseCategoryModel);

    }

}
