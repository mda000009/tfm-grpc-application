package com.isia.tfm.service.impl;

import com.isia.tfm.UserManagementServiceGrpc;
import com.isia.tfm.User;
import com.isia.tfm.CreateUserResponse;
import com.isia.tfm.GetUsersByGenderRequest;
import com.isia.tfm.GetUsersByGenderResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class UserManagementGrpcService extends UserManagementServiceGrpc.UserManagementServiceImplBase {

    private final UserManagementService userManagementService;

    @Autowired
    public UserManagementGrpcService(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @Override
    public void createUser(User request, StreamObserver<CreateUserResponse> responseObserver) {
        try {
            // Convert gRPC User to application User model
            com.isia.tfm.model.User user = new com.isia.tfm.model.User();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            user.setGender(request.getGender());

            // Call the service logic
            CreateUser201Response serviceResponse = userManagementService.createUser(user);

            // Build gRPC response
            CreateUserResponse response = CreateUserResponse.newBuilder()
                    .setUsername(serviceResponse.getData().getUsername())
                    .setMessage(serviceResponse.getData().getMessage())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getUsersByGender(GetUsersByGenderRequest request, StreamObserver<GetUsersByGenderResponse> responseObserver) {
        // Lógica para obtener usuarios por género
        GetUsersByGenderResponse response = GetUsersByGenderResponse.newBuilder()
                .addUsers(User.newBuilder()
                        .setFirstName("Juan")
                        .setLastName("Pérez")
                        .setUsername("juanperez")
                        .setGender(request.getGender())
                        .setEmail("juan.perez@example.com")
                        .build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}