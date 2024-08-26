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
}
