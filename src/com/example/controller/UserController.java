package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Login;
import com.example.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginForm(ModelMap model) {
        model.put("login", new Login());
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, ModelMap model) {
        session.invalidate();
        return "redirect:/";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userValidation(Login login, ModelMap model) {
        if (!userService.isValidUser(login)) {
            return "redirect:/";
        }
        return "home";
    }
}
