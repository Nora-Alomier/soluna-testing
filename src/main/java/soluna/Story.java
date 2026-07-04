package soluna;

/**
 * Represents a single journal entry ("Story") created by a user.
 */
public class Story {

    private String content;

    public Story(String content) {
        this.content = content;
    }

    public boolean isSaved() {
        return content != null && !content.isEmpty();
    }

    public String getContent() {
        return content;
    }
}
