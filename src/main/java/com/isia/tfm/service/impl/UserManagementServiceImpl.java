package com.isia.tfm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isia.tfm.entity.ApplicationUserEntity;
import com.isia.tfm.exception.CustomException;
import com.isia.tfm.model.*;
import com.isia.tfm.repository.ApplicationUserRepository;
import com.isia.tfm.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final ObjectMapper objectMapperFailOnUnknown;
    private final ObjectMapper objectMapperIgnoreUnknown;
    PasswordEncoder passwordEncoder;
    ApplicationUserRepository applicationUserRepository;

    public UserManagementServiceImpl(@Qualifier("objectMapperFailOnUnknown") ObjectMapper objectMapperFailOnUnknown,
                                     @Qualifier("objectMapperIgnoreUnknown") ObjectMapper objectMapperIgnoreUnknown,
                                     PasswordEncoder passwordEncoder,
                                     ApplicationUserRepository applicationUserRepository) {
        this.objectMapperFailOnUnknown = objectMapperFailOnUnknown;
        this.objectMapperIgnoreUnknown = objectMapperIgnoreUnknown;
        this.passwordEncoder = passwordEncoder;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public CreateUser201Response createUser(User user) {
        CreateUser201Response createUser201Response = new CreateUser201Response();
        checkUsernameAndEmail(user);
        log.debug("Username and email checked");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ApplicationUserEntity applicationUserEntity = objectMapperFailOnUnknown.convertValue(user, ApplicationUserEntity.class);
        applicationUserEntity.setCreationDate(LocalDateTime.now());

        applicationUserEntity = applicationUserRepository.save(applicationUserEntity);
        if (applicationUserEntity.getUsername() != null) {
            log.debug("User successfully created");
            CreateUser201ResponseData data = new CreateUser201ResponseData();
            data.setUsername(user.getUsername());
            data.setMessage("User successfully created.");
            createUser201Response.setData(data);
        } else {
            throw new CustomException("500", "Internal Server Error", "Internal Server Error");
        }

        return createUser201Response;
    }

    private void checkUsernameAndEmail(User user) {
        List<ApplicationUserEntity> applicationUserEntityList = applicationUserRepository.findAll();
        boolean usernameExists = applicationUserEntityList.stream()
                .anyMatch(entity -> Objects.equals(user.getUsername(), entity.getUsername()));
        boolean emailExists = applicationUserEntityList.stream()
                .anyMatch(entity -> Objects.equals(user.getEmail(), entity.getEmail()));

        if (usernameExists) {
            log.error("The username is already in use");
            throw new CustomException("409", "Conflict", "The username is already in use");
        } else if (emailExists) {
            log.error("The email is already in use");
            throw new CustomException("409", "Conflict", "The email is already in use");
        }
    }

    @Override
    public GetUsersByGender200Response getUsersByGender(String gender) {
        validateGender(gender);
        GetUsersByGender200Response getUsersByGender200Response = new GetUsersByGender200Response();

        List<ApplicationUserEntity> applicationUserEntityList = applicationUserRepository.findByGender(gender);

        List<ReturnUser> data = applicationUserEntityList.stream()
                .map(entity -> objectMapperIgnoreUnknown.convertValue(entity, ReturnUser.class))
                .toList();

        getUsersByGender200Response.setData(data);

        return getUsersByGender200Response;
    }

    private void validateGender(String gender) {
        if (gender != null && !gender.isEmpty() && !gender.equals("Male") && !gender.equals("Female") && !gender.equals("Another")) {
            throw new CustomException("400", "Bad Request", "Gender param must be Male, Female or Another");
        }
    }

}
