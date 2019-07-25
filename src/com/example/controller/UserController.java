package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Login;
import com.example.domain.User;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginForm(ModelMap model) {
    	
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userValidation(@ModelAttribute("ShoppingCart")Login login, ModelMap model) {
    	
    	if(!userService.isValidUser(login)) {
    		return loginForm(model);
    	}
    	
    	return new ModelAndView("home");
    }

}