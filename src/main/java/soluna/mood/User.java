package soluna.mood;

/**
 * Minimal user reference used by the mood-tracking module to link
 * mood records back to the account that created them.
 */
public class User {

    public String username;

    public User(String username) {
        this.username = username;
    }
}
