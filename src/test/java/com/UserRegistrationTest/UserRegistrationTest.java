package com.UserRegistrationTest;

import com.UserRegistration.UserRegistration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
    @Test
    public void givenFirstName_whenValid_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateFirstName("Abhi");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_whenInvalid_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateFirstName("ab");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenLastName_whenValid_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateLastName("Sontakke");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenInvalid_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateLastName("so");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenEmail_whenValid_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateEmail("abc.xyz@bl.co.in");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_whenInvalid_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateEmail("abc@.com");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenMobileNumber_whenValid_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateMobileNumber("91 9919819801");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_whenInvalid_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateMobileNumber("919919819801");
        Assertions.assertFalse(result);
    }

    // Password Rule 1 Test
    @Test
    public void givenPassword_whenValidLength_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule1("Password1!");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_whenInvalidLength_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule1("Pass1!");
        Assertions.assertFalse(result);
    }
}
