package com.kevin.man.zilch_spending_analyser.controller;

import com.kevin.man.zilch_spending_analyser.dto.Account;
import com.kevin.man.zilch_spending_analyser.dto.CreateAccount;
import com.kevin.man.zilch_spending_analyser.dto.PurchaseCategoryMap;
import com.kevin.man.zilch_spending_analyser.service.ZilchSpendingAnalyserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(produces = "application/json")
public class ZilchSpendingAnalyserController {

    private ZilchSpendingAnalyserService zilchSpendingAnalyserService;

    @Autowired
    ZilchSpendingAnalyserController(ZilchSpendingAnalyserService zilchSpendingAnalyserService) {
        this.zilchSpendingAnalyserService = zilchSpendingAnalyserService;
    }

    @ApiOperation(value = "Get All Accounts", notes = "Find all Account")
    @ApiResponses(value = @ApiResponse(code = 200, message = "All Accounts data retrieved successfully"))
    @GetMapping(value = "/account")
    public List<Account> getAccounts() {
        return zilchSpendingAnalyserService.getAccounts();
    }

    @ApiOperation(value = "Create Account", notes = "Create a new Account")
    @ApiResponses(value = @ApiResponse(code = 201, message = "Account created successfully"))
    @PostMapping(value = "/account")
    public Account createAccount(@Valid @RequestBody final CreateAccount account) {
        return zilchSpendingAnalyserService.createAccount(account);
    }

    @ApiOperation(value = "Get All Transactions of an Account", notes = "Find all Transactions of an Account")
    @ApiResponses(value = @ApiResponse(code = 200, message = "All Transactions data retrieved successfully"))
    @GetMapping(value = "/account/{account_id}/transactions")
    public Account getTransactions(@PathVariable("account_id") final UUID accountId) {
        return zilchSpendingAnalyserService.getTransactions(accountId);
    }

    @ApiOperation(value = "Get All Purchase Category Mappings", notes = "Find All Purchase Category Mappings")
    @ApiResponses(value = @ApiResponse(code = 200, message = "All Purchase Category Mappings data retrieved successfully"))
    @GetMapping(value = "/categories")
    public List<PurchaseCategoryMap> getPurchaseCategoryMap() {
        return zilchSpendingAnalyserService.getPurchaseCategoryMaps();
    }

    @ApiOperation(value = "Create Purchase Category Mapping",
            notes = "Create Purchase Category Mapping to a company name")
    @ApiResponses(value = @ApiResponse(code = 201,
            message = "Purchase Category Mapping created successfully"))
    @GetMapping(value = "/categories")
    public PurchaseCategoryMap createPurchaseCategoryMap(@Valid @RequestBody
                                                                       PurchaseCategoryMap purchaseCategoryMap) {
        return zilchSpendingAnalyserService.createPurchaseCategoryMapping(purchaseCategoryMap);
    }

}
