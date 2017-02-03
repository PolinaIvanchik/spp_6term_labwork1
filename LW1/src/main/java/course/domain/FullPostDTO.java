package course.domain;

import java.util.List;

/**
 * Created by Артем on 03.02.2017.
 */
public class FullPostDTO {
    private Post post;
    private List<Comment> comments;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
