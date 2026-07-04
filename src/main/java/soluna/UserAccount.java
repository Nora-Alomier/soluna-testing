package soluna;

/**
 * Represents a user account and validates registration credentials.
 * A valid account requires a non-empty username and a password of
 * at least 6 characters.
 */
public class UserAccount {

    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        return username != null && !username.isEmpty()
                && password != null && password.length() >= 6;
    }
}
