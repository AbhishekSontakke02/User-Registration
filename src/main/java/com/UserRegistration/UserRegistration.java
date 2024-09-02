package com.UserRegistration;

import java.util.function.Predicate;

public class UserRegistration {
    // Lambda Functions for Validation
    private static final Predicate<String> firstNamePattern = name -> name.matches("^[A-Z][a-zA-Z]{2,}$");
    private static final Predicate<String> lastNamePattern = name -> name.matches("^[A-Z][a-zA-Z]{2,}$");
    private static final Predicate<String> emailPattern = email -> email.matches("^[a-zA-Z0-9]+([._%+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}){1,2}$");
    private static final Predicate<String> mobilePattern = mobile -> mobile.matches("^[0-9]{2} [0-9]{10}$");
    private static final Predicate<String> passwordPattern = password -> password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{8,}$");


    public boolean validateFirstName(String firstName) throws InvalidUserDtlsException {
        if(!firstNamePattern.test(firstName)){
            throw new InvalidUserDtlsException("Invalid First Name");
        }
        return true;
    }

    public boolean validateLastName(String lastName) throws InvalidUserDtlsException {
        if(!lastNamePattern.test(lastName)){
            throw  new InvalidUserDtlsException("Invalid Last Name");
        }
        return true;
    }

    public boolean validateEmail(String email)throws InvalidUserDtlsException {
        if(!emailPattern.test(email)){
            throw new InvalidUserDtlsException("Invalid Email!");
        }
        return true;

    }

    public boolean validateMobileNumber(String mobileNumber) throws InvalidUserDtlsException {
        if(!mobilePattern.test(mobileNumber)){
            throw new InvalidUserDtlsException("Invalid Phone Number!");
        }
        return true;
    }


    public boolean validatePassword(String password) throws InvalidUserDtlsException {
        if (!validatePasswordRule1(password)) {
            throw new InvalidUserDtlsException("Password should have at least 8 characters");
        }
        if (!validatePasswordRule2(password)) {
            throw new InvalidUserDtlsException("Password should have at least 1 uppercase letter");
        }
        if (!validatePasswordRule3(password)) {
            throw new InvalidUserDtlsException("Password should have at least 1 numeric character");
        }
        if (!validatePasswordRule4(password)) {
            throw new InvalidUserDtlsException("Password should have exactly 1 special character");
        }
        return true;
    }
    public boolean validatePasswordRule1(String password) {
        return passwordPattern.test(password);
    }
    public boolean validatePasswordRule2(String password) {
        return passwordPattern.test(password);
    }

    public boolean validatePasswordRule3(String password) {
        return passwordPattern.test(password);
    }

    public boolean validatePasswordRule4(String password) {
        return passwordPattern.test(password);
    }

    public String validateUserDtls(String fName, String lName,String email,String pass,String mobNo) throws InvalidUserDtlsException {
        if( validateFirstName(fName)&&
            validateLastName(lName)&&
            validateEmail(email)&&
            validateMobileNumber(mobNo)&&
            validatePassword(pass)
                ){
                return "happy";
        } else {
            return "sad";
        }
    }
}
