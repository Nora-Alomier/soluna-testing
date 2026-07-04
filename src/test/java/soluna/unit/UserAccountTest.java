package soluna.unit;

import org.junit.jupiter.api.Test;
import soluna.UserAccount;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the User Accounts module: validates username/password
 * combinations, including boundary conditions on password length.
 * Covers TC-UA-01 through TC-UA-04.
 */
public class UserAccountTest {

    @Test
    void TC_UA_01_CreateValidUserAccount() {
        UserAccount user = new UserAccount("zaina123", "password123");
        assertTrue(user.isValid());
    }

    @Test
    void TC_UA_02_EmptyUsername() {
        UserAccount user = new UserAccount("", "password123");
        assertFalse(user.isValid());
    }

    @Test
    void TC_UA_03_ShortPassword() {
        UserAccount user = new UserAccount("zaina123", "123");
        assertFalse(user.isValid());
    }

    @Test
    void TC_UA_04_BoundaryPasswordLength() {
        UserAccount user = new UserAccount("zaina123", "123456");
        assertTrue(user.isValid());
    }
}
