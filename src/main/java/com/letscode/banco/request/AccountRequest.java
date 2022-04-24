package com.letscode.banco.request;

import com.letscode.banco.model.Account;
import com.letscode.banco.model.AccountType;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class AccountRequest {
    private Integer userId;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private AccountType accountType;

    public AccountRequest(Account account) {
        this.number = account.getNumber();
        this.agency = account.getAgency();
        this.balance = account.getBalance();
        this.accountType = account.getAccountType();
        this.userId = account.getUser().getId();
    }
}
