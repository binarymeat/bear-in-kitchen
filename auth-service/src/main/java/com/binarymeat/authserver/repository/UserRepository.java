package com.binarymeat.authserver.repository;

import com.binarymeat.authserver.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rob on 12/5/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
