package com.UserRegistration;

public class UserRegistration {
    public boolean validateFirstName(String firstName) {
        return firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    public boolean validateLastName(String lastName) {
        return lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    public boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+[a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public boolean validateMobileNumber(String mobileNumber) {
        return mobileNumber.matches("^[0-9]{2} [0-9]{10}$");
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

    public boolean validatePassword(String password) {
        return validatePasswordRule1(password) &&
                validatePasswordRule2(password) &&
                validatePasswordRule3(password) &&
                validatePasswordRule4(password);
    }

    public String validateUserDtls(String fName, String lName,String email,String pass,String mobNo) {
        if( validateFirstName(fName)&&
            validateLastName(lName)&&
            validateEmail(email)&&
            validateMobileNumber(mobNo)&&
            validatePassword(pass)
                ){
            System.out.println("test");
                return "happy";
        } else {
            return "sad";
        }
    }
}
