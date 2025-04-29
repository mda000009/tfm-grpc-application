package com.isia.tfm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isia.tfm.UserManagementServiceGrpc;
import com.isia.tfm.Usermanagement;
import com.isia.tfm.exception.CustomException;
import com.isia.tfm.model.dto.UserDto;
import com.isia.tfm.repository.ApplicationUserRepository;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@GrpcService
public class UserManagementGrpcService extends UserManagementServiceGrpc.UserManagementServiceImplBase {

    private final ObjectMapper objectMapperFailOnUnknown;
    private final ObjectMapper objectMapperIgnoreUnknown;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserRepository applicationUserRepository;

    public UserManagementGrpcService(@Qualifier("objectMapperFailOnUnknown") ObjectMapper objectMapperFailOnUnknown,
                                     @Qualifier("objectMapperIgnoreUnknown") ObjectMapper objectMapperIgnoreUnknown,
                                     PasswordEncoder passwordEncoder,
                                     ApplicationUserRepository applicationUserRepository) {
        this.objectMapperFailOnUnknown = objectMapperFailOnUnknown;
        this.objectMapperIgnoreUnknown = objectMapperIgnoreUnknown;
        this.passwordEncoder = passwordEncoder;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void createUser(Usermanagement.User request, StreamObserver<Usermanagement.CreateUserResponse> responseObserver) {
        try {
            UserDto user = new UserDto(request.getFirstName(), request.getLastName(), request.getUsername(),
                    request.getPassword(), request.getBirthdate(), request.getGender(),
                    request.getEmail(), request.getPhoneNumber());

            checkUsernameAndEmail(user);
            log.debug("Username and email checked");

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            com.isia.tfm.entity.ApplicationUserEntity applicationUserEntity = objectMapperFailOnUnknown.convertValue(user, com.isia.tfm.entity.ApplicationUserEntity.class);
            applicationUserEntity.setCreationDate(LocalDateTime.now());

            applicationUserEntity = applicationUserRepository.save(applicationUserEntity);
            if (applicationUserEntity.getUsername() != null) {
                log.debug("User successfully created");

                Usermanagement.CreateUserResponse response = Usermanagement.CreateUserResponse.newBuilder()
                        .setUsername(user.getUsername())
                        .setMessage("User successfully created.")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                throw new CustomException("13", "Internal Server Error", "Internal Server Error");
            }
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    private void checkUsernameAndEmail(UserDto user) {
        List<com.isia.tfm.entity.ApplicationUserEntity> applicationUserEntityList = applicationUserRepository.findAll();
        boolean usernameExists = applicationUserEntityList.stream()
                .anyMatch(entity -> Objects.equals(user.getUsername(), entity.getUsername()));
        boolean emailExists = applicationUserEntityList.stream()
                .anyMatch(entity -> Objects.equals(user.getEmail(), entity.getEmail()));

        if (usernameExists) {
            log.error("The username is already in use");
            throw new CustomException("6", "Already exists", "The username is already in use");
        } else if (emailExists) {
            log.error("The email is already in use");
            throw new CustomException("6", "Already exists", "The email is already in use");
        }
    }

    @Override
    public void getUsersByGender(Usermanagement.GetUsersByGenderRequest request, StreamObserver<Usermanagement.GetUsersByGenderResponse> responseObserver) {
        validateGender(request.getGender());

        List<com.isia.tfm.entity.ApplicationUserEntity> applicationUserEntityList = applicationUserRepository.findByGender(request.getGender());

        List<Usermanagement.ReturnUser> data = applicationUserEntityList.stream()
                .map(entity -> Usermanagement.ReturnUser.newBuilder()
                        .setUsername(entity.getUsername())
                        .setFirstName(entity.getFirstName())
                        .setLastName(entity.getLastName())
                        .setBirthdate(entity.getBirthdate().toString())
                        .setEmail(entity.getEmail())
                        .setPhoneNumber(entity.getPhoneNumber())
                        .build())
                .toList();

        Usermanagement.GetUsersByGenderResponse response = Usermanagement.GetUsersByGenderResponse.newBuilder()
                .addAllUsers(data)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void validateGender(String gender) {
        if (gender != null && !gender.isEmpty() && !gender.equals("Male") && !gender.equals("Female") && !gender.equals("Another")) {
            throw new CustomException("3", "Invalid argument", "Gender param must be Male, Female or Another");
        }
    }
}