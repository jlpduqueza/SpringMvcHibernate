package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Login;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String loginForm(ModelMap model) {
        model.put("login", new Login());
        return "admin-home";
    }
}
