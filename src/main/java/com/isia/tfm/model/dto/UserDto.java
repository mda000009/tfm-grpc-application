package com.isia.tfm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    String firstName;
    String lastName;
    String username;
    String password;
    String birthdate;
    String gender;
    String email;
    String phoneNumber;

}
