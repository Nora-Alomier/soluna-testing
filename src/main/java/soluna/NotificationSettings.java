package soluna;

/**
 * Stores and manages a user's notification preference (enabled/disabled).
 */
public class NotificationSettings {

    private boolean isEnabled;

    public NotificationSettings(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void toggle() {
        isEnabled = !isEnabled;
    }
}
