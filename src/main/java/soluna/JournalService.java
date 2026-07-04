package soluna;

/**
 * Coordinates journal-related behavior that spans the User and Journal
 * modules: creation permissions, entry retrieval, and locked-journal access.
 */
public class JournalService {

    public boolean canCreateJournal(boolean isLoggedIn) {
        return isLoggedIn;
    }

    public boolean hasEntries(String[] journals) {
        return journals != null && journals.length > 0;
    }

    public boolean canAccessLockedJournal(boolean correctPassword) {
        return correctPassword;
    }
}
