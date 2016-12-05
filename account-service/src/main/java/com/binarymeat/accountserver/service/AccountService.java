package com.binarymeat.accountserver.service;

import com.binarymeat.accountserver.domain.Account;
import com.binarymeat.accountserver.domain.User;

/**
 * Created by rob on 12/5/16.
 */
public interface AccountService {
    Account findByName(String accountName);

    Account create(User user);

    void saveChanges(String name, Account update);
}
