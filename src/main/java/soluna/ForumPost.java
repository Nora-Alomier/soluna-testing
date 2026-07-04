package soluna;

/**
 * Represents a post created by a user in the community discussion forum.
 */
public class ForumPost {

    private String content;
    private String userId;

    public ForumPost(String content, String userId) {
        this.content = content;
        this.userId = userId;
    }

    public boolean isValid() {
        return content != null && !content.isEmpty();
    }

    public String getUserId() {
        return userId;
    }
}
