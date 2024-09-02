package com.UserRegistrationTest;

import com.UserRegistration.InvalidUserDtlsException;
import com.UserRegistration.UserRegistration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collection;

public class UserRegistrationTest {
    @Test
    public void givenFirstName_whenValid_shouldReturnTrue() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateFirstName("Abhi");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_whenInvalid_shouldReturnFalse() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertThrows(InvalidUserDtlsException.class,() ->{
            userRegistration.validateFirstName("ab");
        });
//        Assertions.assertFalse(result);
    }

    @Test
    public void givenLastName_whenValid_shouldReturnTrue() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateLastName("Sontakke");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenInvalid_shouldReturnFalse() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertThrows(InvalidUserDtlsException.class,()->{
            userRegistration.validateLastName("so");
        });
    }

    @Test
    public void givenEmail_whenValid_shouldReturnTrue() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateEmail("abc@gmail.com.com");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_whenInvalid_shouldReturnFalse() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertThrows(InvalidUserDtlsException.class, ()->{
            userRegistration.validateEmail("abc()*@gmail.com");
        });
    }

    @Test
    public void givenMobileNumber_whenValid_shouldReturnTrue() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateMobileNumber("91 9919819801");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_whenInvalid_shouldReturnFalse() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertThrows(InvalidUserDtlsException.class,()->{
            userRegistration.validateMobileNumber("919919819801");
        });
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
    public void givenPassword_whenAllRulesPassed_shouldReturnTrue() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePassword("Password1!");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_whenAnyRuleFails_shouldReturnFalse() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertThrows(InvalidUserDtlsException.class,()->{
            userRegistration.validatePassword("Pass1!");
        });
    }

    @Test
    public void givenUserDetails_whenValid_ShouldReturnHappy() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        String result = userRegistration.validateUserDtls("Abhi","Sontakke","abc+100@gmail.com","Password1!","91 9919819801");
        Assertions.assertEquals("happy",result);
    }

    @Test
    public void givenUserDetails_whenInvalid_ShouldReturnSad() throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertThrows(InvalidUserDtlsException.class, () ->{
            userRegistration.validateUserDtls("ab","so","abc()*@gmail.com","pass1","919919819801");
        });
    }

    @ParameterizedTest
    @CsvSource({
            "abc@yahoo.com, true",
            "abc111@abc.com, true",
            "abc.100@abc.com.au, true",
    })
    void givenEmailAsVar_shouldReturnAsPerExpectedResult(String email, boolean expectedResult) throws InvalidUserDtlsException {
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertEquals(expectedResult, userRegistration.validateEmail(email));
    }

    @ParameterizedTest
    @CsvSource({
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com"
    })
    void givenEmailAsVar_ShouldReturnExceptionAsInvalidEmail(String email){
        UserRegistration userRegistration = new UserRegistration();
        Assertions.assertThrows(InvalidUserDtlsException.class, ()->{
            userRegistration.validateEmail(email);
        });
    }

}
