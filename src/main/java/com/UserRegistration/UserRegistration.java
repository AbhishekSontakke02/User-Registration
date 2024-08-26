package com.UserRegistration;

public class UserRegistration {
    public boolean validateFirstName(String firstName) {
        return firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    public boolean validateLastName(String lastName) {
        return lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    public boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
}
