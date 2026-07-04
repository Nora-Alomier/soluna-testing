package soluna.mood;

import java.util.Date;

/**
 * A single recorded mood entry with a timestamp.
 */
public class MoodRecord {

    public String mood;
    public Date date;

    public MoodRecord(String mood) {
        this.mood = mood;
        this.date = new Date();
    }
}
