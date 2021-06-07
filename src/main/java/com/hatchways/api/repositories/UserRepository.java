package com.hatchways.api.repositories;

import com.hatchways.api.domain.User;
import com.hatchways.api.exceptions.EtAuthException;

public interface UserRepository {
    Integer create(String userName, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
