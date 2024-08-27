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
        boolean result = userRegistration.validateEmail("abc@gmail.com.com");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_whenInvalid_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateEmail("abc()*@gmail.com");
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

    // Password Rule 2 Test
    @Test
    public void givenPassword_whenContainsUpperCase_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule2("Password1!");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_whenNoUpperCase_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule2("password1!");
        Assertions.assertFalse(result);
    }

    // Password Rule 3 Test
    @Test
    public void givenPassword_whenContainsNumeric_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule3("Password1!");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_whenNoNumeric_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule3("Password!");
        Assertions.assertFalse(result);
    }

    // Password Rule 4 Test
    @Test
    public void givenPassword_whenContainsSpecialCharacter_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule4("Password1!");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_whenNoSpecialCharacter_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePasswordRule4("Password1");
        Assertions.assertFalse(result);
    }

    // Full Password Validation Test
    @Test
    public void givenPassword_whenAllRulesPassed_shouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePassword("Password1!");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_whenAnyRuleFails_shouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePassword("Pass1!");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenUserDetails_whenValid_ShouldReturnHappy() {
        UserRegistration userRegistration = new UserRegistration();
        String result = userRegistration.validateUserDtls("Abhi","Sontakke","abc+100@gmail.com","Password1!","91 9919819801");
        Assertions.assertEquals("happy",result);
    }

    @Test
    public void givenUserDetails_whenInvalid_ShouldReturnSad() {
        UserRegistration userRegistration = new UserRegistration();
        String result = userRegistration.validateUserDtls("ab","so","abc()*@gmail.com","pass1","919919819801");
        Assertions.assertEquals("sad",result);
    }
}
