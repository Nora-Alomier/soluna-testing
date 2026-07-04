package soluna.unit;

import org.junit.jupiter.api.Test;
import soluna.NotificationSettings;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Notifications module (enable/disable state).
 * Covers TC-NT-01 and TC-NT-02.
 */
public class NotificationUnitTest {

    @Test
    void TC_NT_01_EnableNotifications() {
        NotificationSettings setting = new NotificationSettings(true);
        assertTrue(setting.isEnabled());
    }

    @Test
    void TC_NT_02_DisableNotifications() {
        NotificationSettings setting = new NotificationSettings(false);
        assertFalse(setting.isEnabled());
    }
}
