package com.binarymeat.accountservice.service.impl;

import com.binarymeat.accountservice.client.AuthClient;
import com.binarymeat.accountservice.client.StatisticsClient;
import com.binarymeat.accountservice.domain.Account;
import com.binarymeat.accountservice.domain.User;
import com.binarymeat.accountservice.repository.AccountRepository;
import com.binarymeat.accountservice.service.AccountService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by rob on 12/5/16.
 */
@Service
public class AccountServiceImpl implements AccountService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private StatisticsClient statisticsClient;

    @Autowired
    private AuthClient authClient;

    @Autowired
    private AccountRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Account findByName(String accountName) {
        Assert.hasLength(accountName);
        return repository.findByName(accountName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account create(User user) {

        Account existing = repository.findByName(user.getUsername());
        Assert.isNull(existing, "account already exists: " + user.getUsername());

        authClient.createUser(user);

        Account account = new Account();
        account.setName(user.getUsername());
        account.setLastSeen(new Date());

        repository.save(account);

        log.info("new account has been created: " + account.getName());

        return account;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveChanges(String name, Account update) {

        Account account = repository.findByName(name);
        Assert.notNull(account, "can't find account with name " + name);

        account.setLastSeen(new Date());
        repository.save(account);

        log.debug("account {} changes has been saved", name);

        statisticsClient.updateStatistics(name, account);
    }

    @Override
    public List<Account> findAll() {
        return Lists.newArrayList(repository.findAll());
    }
}
