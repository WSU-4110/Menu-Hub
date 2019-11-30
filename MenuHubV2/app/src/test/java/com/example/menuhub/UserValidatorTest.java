package com.example.menuhub;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class UserValidatorTest {

    @Test
    public void UserValidator_CorrectUserSimple_ReturnsTrue() {
        assertTrue(UserValidator.isValidUser("name@email.com"));
    }

    @Test
    public void UserValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(UserValidator.isValidUser("name@email.co.uk"));
    }
    @Test
    public void UserValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(UserValidator.isValidUser("name@email"));
    }
    @Test
    public void UserValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(UserValidator.isValidUser("name@email..com"));
    }
    @Test
    public void UserValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(UserValidator.isValidUser("@email.com"));
    }
    @Test
    public void UserValidator_EmptyString_ReturnsFalse() {
        assertFalse(UserValidator.isValidUser(""));
    }
    @Test
    public void UserValidator_NullEmail_ReturnsFalse() {
        assertFalse(UserValidator.isValidUser(null));
    }


    @Test
    public void validPassLen_True() {
        assertTrue(UserValidator.validPassLen("changethename"));
    }
    @Test
    public void validPassLen_False() {
        assertFalse(UserValidator.validPassLen("changethename"));
    }
    @Test
    public void validPassFormat_False() {
        assertFalse(UserValidator.validPassFormat("pass"));
    }
    @Test
    public void validPassFormat_True() {
        assertTrue(UserValidator.validPassFormat("pass"));
    }
    @Test
    public void isValidUser_True() {
        assertTrue(UserValidator.isValidUser("name@email.com"));
    }
    @Test
    public void isValidUser_False() {
        assertFalse(UserValidator.isValidUser("name@email.com"));
    }

}