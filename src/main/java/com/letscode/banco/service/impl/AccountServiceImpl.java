package com.letscode.banco.service.impl;

import com.letscode.banco.model.Account;
import com.letscode.banco.repository.AccountRepository;
import com.letscode.banco.request.AccountRequest;
import com.letscode.banco.service.AccountService;
import com.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserService userService;

    @Override
    public Account create(AccountRequest accountRequest) {
        return null;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }
}
