package soluna.unit;

import org.junit.jupiter.api.Test;
import soluna.Story;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Journaling module (Story creation and retrieval).
 * Covers TC-JR-01 and TC-JR-02.
 */
public class JournalingUnitTest {

    @Test
    void TC_JR_01_CreateJournalEntry() {
        Story story = new Story("Today I felt productive.");
        assertNotNull(story);
        assertTrue(story.isSaved());
    }

    @Test
    void TC_JR_02_RetrieveJournal() {
        Story story = new Story("My saved journal entry");
        assertNotNull(story.getContent());
        assertEquals("My saved journal entry", story.getContent());
    }
}
