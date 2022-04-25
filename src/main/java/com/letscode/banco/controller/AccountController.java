package com.letscode.banco.controller;

import com.letscode.banco.model.Account;
import com.letscode.banco.request.AccountRequest;
import com.letscode.banco.response.AccountResponse;
import com.letscode.banco.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public AccountResponse create (@RequestBody AccountRequest accountRequest) {
        Account account = accountService.create(accountRequest);
        return new AccountResponse(account);
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable Integer id) {
        Optional<Account> account = accountService.findById(id);
        return new AccountResponse(account.get());
    }
}
