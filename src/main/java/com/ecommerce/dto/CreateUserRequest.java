package com.ecommerce.dto;

import org.springframework.stereotype.Component;

@Component
public class CreateUserRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String middleName;

    public CreateUserRequest(String email, String firstName, String lastName, String middleName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public CreateUserRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
