package com.UserRegistration;

public class UserRegistration {
    public boolean validateFirstName(String firstName) throws InvalidUserDtlsException {
        if(!firstName.matches("^[A-Z][a-zA-Z]{2,}$")){
            throw new InvalidUserDtlsException("Invalid First Name");
        }
        return true;
    }

    public boolean validateLastName(String lastName) throws InvalidUserDtlsException {
        if(!lastName.matches("^[A-Z][a-zA-Z]{2,}$")){
            throw  new InvalidUserDtlsException("Invalid Last Name");
        }
        return true;
    }

    public boolean validateEmail(String email)throws InvalidUserDtlsException {
        if(!email.matches("^[a-zA-Z0-9]+([._%+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}){1,2}$")){
            throw new InvalidUserDtlsException("Invalid Email!");
        }
        return true;

    }

    public boolean validateMobileNumber(String mobileNumber) throws InvalidUserDtlsException {
        if(!mobileNumber.matches("^[0-9]{2} [0-9]{10}$")){
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
        return password.length() >= 8;
    }
    public boolean validatePasswordRule2(String password) {
        return password.matches(".*[A-Z].*");
    }

    public boolean validatePasswordRule3(String password) {
        return password.matches(".*[0-9].*");
    }

    public boolean validatePasswordRule4(String password) {
        return password.matches("^(?=.*[!@#$%^&*(),.?\":{}|<>])[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]{8,}$");
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
