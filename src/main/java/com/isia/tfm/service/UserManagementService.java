package com.isia.tfm.service;

import com.isia.tfm.model.CreateUser201Response;
import com.isia.tfm.model.GetUsersByGender200Response;
import com.isia.tfm.model.User;

/**
 * Service interface for managing users.
 */
public interface UserManagementService {

    /**
     *
     * @param user the user
     * @return {@link CreateUser201Response}
     */
    CreateUser201Response createUser(User user);

    /**
     *
     * @param gender the gender
     * @return {@link GetUsersByGender200Response}
     */
    GetUsersByGender200Response getUsersByGender(String gender);

}