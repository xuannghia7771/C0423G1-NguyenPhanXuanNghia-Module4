package com.example.user_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    @NotEmpty(message = "Not Empty")
    @Size(min = 5,max = 45, message ="last name in 5 to 45 characters")
    private String firstName;
    @NotEmpty(message = "Not Empty")
    @Size(min = 5,max = 45, message ="last name in 5 to 45 characters")
    private String lastName;
    private String phoneNumber;
    @Min(value = 18, message = "Age not less than 18")
    private int age;
    @Email
    private String email;

    public UserDto() {

    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().equals("")){
            errors.rejectValue("phoneNumber",null,"Not Empty!");
        } else if (!userDto.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", null, "Invalid Phone Number!");
        }
    }
}
