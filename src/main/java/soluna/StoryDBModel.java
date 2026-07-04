package soluna;

import java.time.LocalDate;

/**
 * Simple database-model stand-in for a journal entry, used by
 * UserIntegrationTest to simulate a registered user's stored journal.
 *
 * NOTE: This class was referenced in the Phase 3 report's integration
 * test code but was not included as a standalone listing. It has been
 * reconstructed here (minimal implementation matching its usage in
 * UserIntegrationTest) so the test suite compiles and runs as-is.
 */
public class StoryDBModel {

    private final LocalDate createdDate;
    private final String latestContent;

    private StoryDBModel(LocalDate createdDate) {
        this.createdDate = createdDate;
        this.latestContent = "Sample journal content created on " + createdDate;
    }

    public static StoryDBModel fromDate(LocalDate date) {
        return new StoryDBModel(date);
    }

    public String getLatestContent() {
        return latestContent;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
