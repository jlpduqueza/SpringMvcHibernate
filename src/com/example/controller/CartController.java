package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Product;
import com.example.domain.User;
import com.example.service.CartItemService;
import com.example.service.InventoryItemService;

@Controller
@Scope("session")
public class CartController {
	
    @Autowired
    private CartItemService cartItemService;
    
    @Autowired
    private InventoryItemService inventoryItemService;

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public String viewAddToCart(HttpSession session, ModelMap model, @RequestParam("inventoryId") int id,
                                @RequestParam("cartItemQuantity") int quantity) {
        Product product = inventoryItemService.getInventoryItem(id).getProduct();
        User user = (User) session.getAttribute("user");

        cartItemService.addToCart(user, product, quantity);
        model.put("message", "cart item added");
        return "forward:/home";
    }
    
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String viewCart(HttpSession session, ModelMap model) {
    	User user = (User) session.getAttribute("user");
        model.put("cartItemList", cartItemService.getCartItemList(user));
        return "cart";
    }
    
    @RequestMapping(value = "/delete-cart-item", method = RequestMethod.GET)
    public String deleteCartItem(HttpSession session, ModelMap model, @RequestParam("cartItemId") int id) {
    	cartItemService.deleteCartItem(id);
    	return "forward:/cart";
    }
    
}
