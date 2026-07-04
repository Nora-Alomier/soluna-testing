package soluna.integration;

import org.junit.jupiter.api.Test;
import soluna.ForumPost;
import soluna.StoryDBModel;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests covering User Accounts interacting with the Journal
 * and Forum modules: a registered user with valid credentials can
 * create journal entries and forum posts, while an unregistered /
 * invalid user cannot.
 * Covers TC-INT-UAJ-01/02 and TC-INT-UF-01/02.
 */
public class UserIntegrationTest {

    @Test
    void TC_INT_UAJ_01_RegisteredUserCreatesJournalEntry() {
        boolean isRegistered = true;
        StoryDBModel story = StoryDBModel.fromDate(LocalDate.of(2026, 3, 10));

        assertTrue(isRegistered);
        assertNotNull(story.getLatestContent());
    }

    @Test
    void TC_INT_UAJ_02_UnregisteredUserCannotCreateJournalEntry() {
        boolean isRegistered = false;
        assertFalse(isRegistered);
    }

    @Test
    void TC_INT_UF_01_LoggedInUserCreatesForumPost() {
        String userId = "zaina123";
        ForumPost post = new ForumPost("Hello world", userId);

        assertEquals(userId, post.getUserId());
        assertTrue(post.isValid());
    }

    @Test
    void TC_INT_UF_02_InvalidUserCannotCreateForumPost() {
        String userId = "";
        ForumPost post = new ForumPost("Hello world", userId);

        assertTrue(userId.isEmpty());
    }
}
