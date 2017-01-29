package course.controller;

import course.dao.UserRepository;
import course.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by Артем on 29.01.2017.
 */
@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createUser(HttpSession httpSession, @RequestBody String name) {
        userRepository.save(new User(name));
        httpSession.setAttribute("currentUserName", name);
        return "ok";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpSession httpSession, @RequestBody String name) {
        if (userRepository.findByName(name) != null) {
            httpSession.setAttribute("currentUserName", name);
            return "ok";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String log() {
        return "ok";
    }
}
