package com.ecommerce.dto;

public class UsersDto {

    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private boolean isActive;

    public UsersDto() { // for security purpose we create DTO class so we do not use real entity class
    }

    public UsersDto(String email, String firstName, String lastName, String middleName, boolean isActive) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.isActive = isActive;
    }

}
