package com.binarymeat.accountservice.service;

import com.binarymeat.accountservice.domain.Account;
import com.binarymeat.accountservice.domain.User;

import java.util.List;

/**
 * Created by rob on 12/5/16.
 */
public interface AccountService {
    Account findByName(String accountName);

    Account create(User user);

    void saveChanges(String name, Account update);

    List<Account> findAll();
}
