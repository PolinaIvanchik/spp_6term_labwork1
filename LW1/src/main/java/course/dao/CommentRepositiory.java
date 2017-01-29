package course.dao;

import course.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Артем on 29.01.2017.
 */
@Repository
public interface CommentRepositiory  extends JpaRepository<Comment, Long> {
}
