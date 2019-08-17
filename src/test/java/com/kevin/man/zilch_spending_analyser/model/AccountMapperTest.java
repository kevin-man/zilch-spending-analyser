package com.kevin.man.zilch_spending_analyser.model;


import com.kevin.man.zilch_spending_analyser.dto.Account;
import com.kevin.man.zilch_spending_analyser.dto.PurchaseCategoryMap;
import com.kevin.man.zilch_spending_analyser.dto.Transaction;
import com.kevin.man.zilch_spending_analyser.mapper.AccountMapper;
import com.kevin.man.zilch_spending_analyser.model.enums.PurchaseType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class AccountMapperTest {

    private AccountMapper accountMapper = AccountMapper.INSTANCE;
    private static UUID ACCOUNT_ID = UUID.randomUUID();
    private static UUID TRANSACTION_ID = UUID.randomUUID();
    private static UUID PURCHASE_CATEGORY_MAP_ID = UUID.randomUUID();
    private static Transaction TRANSACTION;
    private static TransactionModel TRANSACTION_MODEL;
    private static Account ACCOUNT;
    private static AccountModel ACCOUNT_MODEL;
    private static PurchaseCategoryMap PURCHASE_CATEGORY_MAP;
    private static PurchaseCategoryMapModel PURCHASE_CATEGORY_MAP_MODEL;


    @Before
    public void createTestData() {
        TRANSACTION = Transaction.builder()
                .transactionId(TRANSACTION_ID)
                .company("TEST")
                .price(new BigDecimal(20.10))
                .date(LocalDate.of(2019, 2, 2))
                .build();

        ACCOUNT = Account.builder()
                .accountId(ACCOUNT_ID)
                .accountHolderName("TEST_HOLDER")
                .maxCredit(200)
                .build();

        TRANSACTION_MODEL = TransactionModel.builder()
                .transactionId(TRANSACTION_ID)
                .company("TEST")
                .date(LocalDate.of(2019, 2, 2))
                .price(new BigDecimal(20.10))
                .build();

        ACCOUNT_MODEL = AccountModel.builder()
                .accountHolderName("TEST_HOLDER")
                .accountId(ACCOUNT_ID)
                .maxCredit(200)
                .build();

        PURCHASE_CATEGORY_MAP = PurchaseCategoryMap.builder()
                .companyName("TEST")
                .purchaseType(PurchaseType.OTHER)
                .build();

        PURCHASE_CATEGORY_MAP_MODEL = PurchaseCategoryMapModel.builder()
                .purchaseCategoryMapId(PURCHASE_CATEGORY_MAP_ID)
                .companyName("TEST")
                .purchaseType(PurchaseType.OTHER)
                .build();
    }


    @Test
    public void toAccountTest_Success() {
        Account result = accountMapper.toAccount(ACCOUNT_MODEL);

        assertNotNull(result);
        assertEquals(ACCOUNT, result);
    }

    @Test
    public void toAccountModelTest_Success() {
        AccountModel result = accountMapper.toAccountModel(ACCOUNT);

        assertNotNull(result);
        assertEquals(ACCOUNT_MODEL, result);
    }

    @Test
    public void toTransactionTest_Success() {
        Transaction result = accountMapper.toTransaction(TRANSACTION_MODEL);

        assertNotNull(result);
        assertEquals(TRANSACTION, result);
    }

    @Test
    public void toTransactionModelTest_Successful() {
        TransactionModel result = accountMapper.toTransactionModel(TRANSACTION);

        assertNotNull(result);
        assertEquals(TRANSACTION_MODEL, result);
    }

    @Test
    public void toAccountsTest_Successful() {
        List<AccountModel> accountModels = new ArrayList<>();
        accountModels.add(ACCOUNT_MODEL);
        List<Account> accounts = new ArrayList<>();
        accounts.add(ACCOUNT);

        List<Account> result = accountMapper.toAccounts(accountModels);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(accounts, result);
    }

    @Test
    public void toPurchaseCategory_Successful() {
        PurchaseCategoryMap result = accountMapper.toPurchaseCategoryMap(PURCHASE_CATEGORY_MAP_MODEL);

        assertNotNull(result);
        assertEquals(PURCHASE_CATEGORY_MAP, result);
    }

    @Test
    public void toPurchaseCategoryMap_Successful() {
        PurchaseCategoryMapModel result = accountMapper.toPurchaseCCategoryMapModel(PURCHASE_CATEGORY_MAP);

        assertNotNull(result);
        assertEquals(PURCHASE_CATEGORY_MAP_MODEL.getCompanyName(), result.getCompanyName());
        assertEquals(PURCHASE_CATEGORY_MAP_MODEL.getPurchaseType(), result.getPurchaseType());
    }

    @Test
    public void toPurchaseCategoryMaps_Successful() {
        List<PurchaseCategoryMap> purchaseCategoryMaps = new ArrayList<>();
        purchaseCategoryMaps.add(PURCHASE_CATEGORY_MAP);
        List<PurchaseCategoryMapModel> purchaseCategoryMapModels = new ArrayList<>();
        purchaseCategoryMapModels.add(PURCHASE_CATEGORY_MAP_MODEL);

        List<PurchaseCategoryMap> result = accountMapper.toPurchaseCategoryMaps(purchaseCategoryMapModels);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(purchaseCategoryMaps, result);
    }
}
