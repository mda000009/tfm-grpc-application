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
            UserDto user = new UserDto(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getUsername(),
                    request.getPassword(),
                    request.getBirthdate(),
                    request.getGender(),
                    request.getEmail(),
                    request.getPhoneNumber(),
                    request.getPreference1(),
                    request.getPreference2(),
                    request.getPreference3(),
                    request.getPreference4(),
                    request.getPreference5(),
                    request.getPreference6(),
                    request.getPreference7(),
                    request.getPreference8(),
                    request.getPreference9(),
                    request.getPreference10(),
                    request.getPreference11(),
                    request.getPreference12(),
                    request.getPreference13(),
                    request.getPreference14(),
                    request.getPreference15(),
                    request.getPreference16(),
                    request.getPreference17(),
                    request.getPreference18(),
                    request.getPreference19(),
                    request.getPreference20(),
                    request.getPreference21(),
                    request.getPreference22(),
                    request.getPreference23(),
                    request.getPreference24(),
                    request.getPreference25(),
                    request.getPreference26(),
                    request.getPreference27(),
                    request.getPreference28(),
                    request.getPreference29(),
                    request.getPreference30(),
                    request.getPreference31(),
                    request.getPreference32(),
                    request.getPreference33(),
                    request.getPreference34(),
                    request.getPreference35(),
                    request.getPreference36(),
                    request.getPreference37(),
                    request.getPreference38(),
                    request.getPreference39(),
                    request.getPreference40(),
                    request.getPreference41(),
                    request.getPreference42(),
                    request.getPreference43(),
                    request.getPreference44(),
                    request.getPreference45(),
                    request.getPreference46(),
                    request.getPreference47(),
                    request.getPreference48(),
                    request.getPreference49(),
                    request.getPreference50(),
                    request.getPreference51(),
                    request.getPreference52(),
                    request.getPreference53(),
                    request.getPreference54(),
                    request.getPreference55(),
                    request.getPreference56(),
                    request.getPreference57(),
                    request.getPreference58(),
                    request.getPreference59(),
                    request.getPreference60(),
                    request.getPreference61(),
                    request.getPreference62(),
                    request.getPreference63(),
                    request.getPreference64(),
                    request.getPreference65(),
                    request.getPreference66(),
                    request.getPreference67(),
                    request.getPreference68(),
                    request.getPreference69(),
                    request.getPreference70(),
                    request.getPreference71(),
                    request.getPreference72(),
                    request.getPreference73(),
                    request.getPreference74(),
                    request.getPreference75(),
                    request.getPreference76(),
                    request.getPreference77(),
                    request.getPreference78(),
                    request.getPreference79(),
                    request.getPreference80(),
                    request.getPreference81(),
                    request.getPreference82(),
                    request.getPreference83(),
                    request.getPreference84(),
                    request.getPreference85(),
                    request.getPreference86(),
                    request.getPreference87(),
                    request.getPreference88(),
                    request.getPreference89(),
                    request.getPreference90(),
                    request.getPreference91(),
                    request.getPreference92(),
                    request.getPreference93(),
                    request.getPreference94(),
                    request.getPreference95(),
                    request.getPreference96(),
                    request.getPreference97(),
                    request.getPreference98(),
                    request.getPreference99(),
                    request.getPreference100(),
                    request.getPreference101(),
                    request.getPreference102(),
                    request.getPreference103(),
                    request.getPreference104(),
                    request.getPreference105(),
                    request.getPreference106(),
                    request.getPreference107(),
                    request.getPreference108(),
                    request.getPreference109(),
                    request.getPreference110(),
                    request.getPreference111(),
                    request.getPreference112(),
                    request.getPreference113(),
                    request.getPreference114(),
                    request.getPreference115(),
                    request.getPreference116(),
                    request.getPreference117(),
                    request.getPreference118(),
                    request.getPreference119(),
                    request.getPreference120(),
                    request.getPreference121(),
                    request.getPreference122(),
                    request.getPreference123(),
                    request.getPreference124(),
                    request.getPreference125(),
                    request.getPreference126(),
                    request.getPreference127(),
                    request.getPreference128(),
                    request.getPreference129(),
                    request.getPreference130(),
                    request.getPreference131(),
                    request.getPreference132(),
                    request.getPreference133(),
                    request.getPreference134(),
                    request.getPreference135(),
                    request.getPreference136(),
                    request.getPreference137(),
                    request.getPreference138(),
                    request.getPreference139(),
                    request.getPreference140(),
                    request.getPreference141(),
                    request.getPreference142(),
                    request.getPreference143(),
                    request.getPreference144(),
                    request.getPreference145(),
                    request.getPreference146(),
                    request.getPreference147(),
                    request.getPreference148(),
                    request.getPreference149(),
                    request.getPreference150(),
                    request.getPreference151(),
                    request.getPreference152(),
                    request.getPreference153(),
                    request.getPreference154(),
                    request.getPreference155(),
                    request.getPreference156(),
                    request.getPreference157(),
                    request.getPreference158(),
                    request.getPreference159(),
                    request.getPreference160(),
                    request.getPreference161(),
                    request.getPreference162(),
                    request.getPreference163(),
                    request.getPreference164(),
                    request.getPreference165(),
                    request.getPreference166(),
                    request.getPreference167(),
                    request.getPreference168(),
                    request.getPreference169(),
                    request.getPreference170(),
                    request.getPreference171(),
                    request.getPreference172(),
                    request.getPreference173(),
                    request.getPreference174(),
                    request.getPreference175(),
                    request.getPreference176(),
                    request.getPreference177(),
                    request.getPreference178(),
                    request.getPreference179(),
                    request.getPreference180(),
                    request.getPreference181(),
                    request.getPreference182(),
                    request.getPreference183(),
                    request.getPreference184(),
                    request.getPreference185(),
                    request.getPreference186(),
                    request.getPreference187(),
                    request.getPreference188(),
                    request.getPreference189(),
                    request.getPreference190(),
                    request.getPreference191(),
                    request.getPreference192(),
                    request.getPreference193(),
                    request.getPreference194(),
                    request.getPreference195(),
                    request.getPreference196(),
                    request.getPreference197(),
                    request.getPreference198(),
                    request.getPreference199(),
                    request.getPreference200()
            );

            checkUsernameAndEmail(user);
            log.debug("Username and email checked");

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            com.isia.tfm.model.entity.ApplicationUserEntity applicationUserEntity = objectMapperFailOnUnknown.convertValue(user, com.isia.tfm.model.entity.ApplicationUserEntity.class);
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
        List<com.isia.tfm.model.entity.ApplicationUserEntity> applicationUserEntityList = applicationUserRepository.findAll();
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

        List<com.isia.tfm.model.entity.ApplicationUserEntity> applicationUserEntityList = applicationUserRepository.findByGender(request.getGender());

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