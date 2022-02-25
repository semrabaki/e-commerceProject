package com.ecommerce.dto;

public class UserDetailsDto {

    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private String postCode;

    public UserDetailsDto() {
    }

    public UserDetailsDto(String phoneNumber, String address, String city, String country, String postCode) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
