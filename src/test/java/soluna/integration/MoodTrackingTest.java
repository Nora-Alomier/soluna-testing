package soluna.integration;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import soluna.mood.MoodRecord;
import soluna.mood.MoodTrackingSystem;

import java.util.List;

/**
 * Integration tests covering Mood Tracking + User Accounts: verifies
 * that mood records are correctly linked to the user who created them,
 * and that invalid input (empty username) is rejected while valid mood
 * history is stored and retrieved correctly.
 *
 * Covers TC-MD-01 and TC-MD-02.
 *
 * NOTE: Written with JUnit 4 (org.junit) in the original report, unlike
 * the other test classes which use JUnit 5 (org.junit.jupiter). Kept
 * as-is here; the JUnit Vintage engine (declared in pom.xml) allows
 * this class to run alongside the JUnit 5 tests via `mvn test`.
 */
public class MoodTrackingTest {

    MoodTrackingSystem system;

    @Before
    public void setup() {
        system = new MoodTrackingSystem();
    }

    // TC-MD-01
    @Test
    public void testCreateUserAndAddMood() {
        String username = "user1";
        assertTrue(system.createUser(username));
        assertTrue(system.addMood(username, "Happy"));

        List<MoodRecord> history = system.getMoodHistory(username);
        assertEquals(1, history.size());
        assertEquals("Happy", history.get(0).mood);
    }

    // TC-MD-02
    @Test
    public void testEmptyUsernameAndMoodHistory() {
        String emptyUsername = "";
        assertFalse(system.createUser(emptyUsername));

        String username = "user2";
        system.createUser(username);
        system.addMood(username, "Sad");
        system.addMood(username, "Excited");

        List<MoodRecord> history = system.getMoodHistory(username);
        assertEquals(2, history.size());
        assertEquals("Sad", history.get(0).mood);
        assertEquals("Excited", history.get(1).mood);
    }
}
