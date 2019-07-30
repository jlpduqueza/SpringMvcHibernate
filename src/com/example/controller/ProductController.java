package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Login;
import com.example.domain.User;
import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
    private ProductService productService;
	
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView homePageView(Login login) {

    	return new ModelAndView("home").addObject(login);
    }
	
}
