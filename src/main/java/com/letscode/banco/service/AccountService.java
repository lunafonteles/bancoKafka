package com.letscode.banco.service;

import com.letscode.banco.model.Account;
import com.letscode.banco.request.AccountRequest;

import java.util.Optional;

public interface AccountService {
    Account create (AccountRequest accountRequest);

    Optional<Account> findById(Integer id);
}
