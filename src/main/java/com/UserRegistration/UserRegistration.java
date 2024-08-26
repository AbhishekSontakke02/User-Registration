package com.UserRegistration;

public class UserRegistration {
    public boolean validateFirstName(String firstName) {
        return firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }
}
