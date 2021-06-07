package com.hatchways.api.services;

import com.hatchways.api.domain.User;
import com.hatchways.api.exceptions.EtAuthException;

/**program to an interface whenever we have architectural coupling
 * this interface takes care of validating an existing user and
 * registering a new user.
 **/
public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String userName, String email, String password) throws EtAuthException;
}
