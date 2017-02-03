package course.controller;

import course.dao.CommentRepository;
import course.dao.PostRepository;
import course.dao.UserRepository;
import course.domain.Comment;
import course.domain.FullPostDTO;
import course.domain.Post;
import course.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 03.02.2017.
 */
@Controller
@RequestMapping("/")
public class BlogController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public BlogController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @RequestMapping(value = "/get/post", method = RequestMethod.GET)
    public @ResponseBody List<FullPostDTO> getAllPosts() {
        List<FullPostDTO> allPosts = new ArrayList<>();
        postRepository.findAll().forEach(post -> {
            FullPostDTO postWithComments = new FullPostDTO();
            postWithComments.setPost(post);
            postWithComments.setComments(commentRepository.findByPostId(post.getId()));
            allPosts.add(postWithComments);
        });
        return allPosts;
    }

    @RequestMapping(value = "/add/post", method = RequestMethod.POST)
    public @ResponseBody List<FullPostDTO> addPost(@RequestBody Post post) {
        postRepository.save(post);
        return getAllPosts();
    }

    @RequestMapping(value = "/add/comment", method = RequestMethod.POST)
    public @ResponseBody List<FullPostDTO> addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return getAllPosts();
    }

    @RequestMapping(value = "/user/current", method = RequestMethod.GET)
    public @ResponseBody String getCurrentUser(HttpSession httpSession) {
        return httpSession.getAttribute("currentUserName").toString();
    }
}
