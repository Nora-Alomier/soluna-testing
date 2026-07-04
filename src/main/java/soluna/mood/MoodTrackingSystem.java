package soluna.mood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Integrates user identity with mood history: creates users, records
 * moods against a username, and retrieves stored mood history.
 */
public class MoodTrackingSystem {

    private final Map<String, List<MoodRecord>> moodHistory = new HashMap<>();

    public boolean createUser(String username) {
        return username != null && !username.isEmpty();
    }

    public boolean addMood(String username, String mood) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        moodHistory.putIfAbsent(username, new ArrayList<>());
        moodHistory.get(username).add(new MoodRecord(mood));
        return true;
    }

    public List<MoodRecord> getMoodHistory(String username) {
        return moodHistory.getOrDefault(username, new ArrayList<>());
    }
}
