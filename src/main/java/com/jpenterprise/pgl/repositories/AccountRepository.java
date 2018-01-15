package com.jpenterprise.pgl.repositories;

import com.jpenterprise.pgl.models.Account;

public interface AccountRepository {
    Integer addAccount(Account account);
    Account getAccountByUsernameAndPassword(String username, String password);

}
