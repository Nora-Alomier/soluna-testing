package soluna.integration;

import org.junit.jupiter.api.Test;
import soluna.ForumPost;
import soluna.NotificationSettings;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests covering Forum + Notification Settings: verifies
 * that a forum post is correctly linked to its creator, and that
 * notification state is correctly reflected.
 * Covers TC-INT-FN-01 and TC-INT-NT-01.
 */
public class ForumNotificationIntegrationTest {

    @Test
    void TC_INT_FN_01_PostLinkedToUser() {
        ForumPost post = new ForumPost("Test post", "user123");
        assertEquals("user123", post.getUserId());
    }

    @Test
    void TC_INT_NT_01_NotificationReflectsUserSetting() {
        NotificationSettings setting = new NotificationSettings(false);
        assertFalse(setting.isEnabled());
    }
}
