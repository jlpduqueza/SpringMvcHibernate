package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.service.CartItemService;

@Controller
public class CartController {
	
	@Autowired
    private CartItemService cartItemService;
}
