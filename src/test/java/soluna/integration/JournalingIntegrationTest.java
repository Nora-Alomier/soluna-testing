package soluna.integration;

import org.junit.jupiter.api.Test;
import soluna.JournalService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests covering User + Journal interactions: creation
 * permissions, viewing entries, and locked-journal access.
 * Covers TC-INT-UJ-01/02, TC-INT-JV-01/02, TC-INT-JP-01/02.
 */
public class JournalingIntegrationTest {

    @Test
    void TC_INT_UJ_01_LoggedInUserCreatesJournalEntry() {
        JournalService service = new JournalService();
        assertTrue(service.canCreateJournal(true));
    }

    @Test
    void TC_INT_UJ_02_UnauthorizedUserCannotCreateJournal() {
        JournalService service = new JournalService();
        assertFalse(service.canCreateJournal(false));
    }

    @Test
    void TC_INT_JV_01_UserViewsJournalEntries() {
        JournalService service = new JournalService();
        String[] journals = {"Entry 1"};
        assertTrue(service.hasEntries(journals));
    }

    @Test
    void TC_INT_JV_02_NoJournalEntriesAvailable() {
        JournalService service = new JournalService();
        String[] journals = {};
        assertFalse(service.hasEntries(journals));
    }

    @Test
    void TC_INT_JP_01_AccessLockedJournalWithPassword() {
        JournalService service = new JournalService();
        assertTrue(service.canAccessLockedJournal(true));
    }

    @Test
    void TC_INT_JP_02_AccessLockedJournalWithoutPassword() {
        JournalService service = new JournalService();
        assertFalse(service.canAccessLockedJournal(false));
    }
}
