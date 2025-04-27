package com.isia.tfm.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonCreator;

public class User {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;

    public enum GenderEnum {
        MALE("Male"),

        FEMALE("Female"),

        ANOTHER("Another");

        private String value;

        GenderEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static GenderEnum fromValue(String value) {
            for (GenderEnum b : GenderEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private GenderEnum gender;

    private String email;

    private String phoneNumber;
}
