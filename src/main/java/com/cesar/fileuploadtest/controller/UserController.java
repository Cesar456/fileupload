package com.cesar.fileuploadtest.controller;

import com.cesar.fileuploadtest.model.User;
import com.cesar.fileuploadtest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Cesar on 2016/11/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login_post(User user, HttpSession session) {
        User user1 = userService.checkLogin(user.getName(), user.getPassword());
        logger.info(user1.toString());
        if (user1 == null) {
            return "login";
        } else {
            session.setAttribute("user", user1);
            return "redirect:/file/upload";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login_page() {
        return "login";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String login_out(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }


}
