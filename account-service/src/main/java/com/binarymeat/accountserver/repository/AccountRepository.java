package com.binarymeat.accountserver.repository;

import com.binarymeat.accountserver.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rob on 12/5/16.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, String>{
    Account findByName(String name);
}
