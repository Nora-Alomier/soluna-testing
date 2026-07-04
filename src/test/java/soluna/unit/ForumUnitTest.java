package soluna.unit;

import org.junit.jupiter.api.Test;
import soluna.ForumPost;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Community Forum module (post validation).
 * Covers TC-FN-01 and TC-FN-02.
 */
public class ForumUnitTest {

    @Test
    void TC_FN_01_CreateValidForumPost() {
        ForumPost post = new ForumPost("Hello everyone", "user123");
        assertTrue(post.isValid());
    }

    @Test
    void TC_FN_02_CreateEmptyForumPost() {
        ForumPost post = new ForumPost("", "user123");
        assertFalse(post.isValid());
    }
}
