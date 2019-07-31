package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.CartItem;
import com.example.domain.InventoryItem;
import com.example.domain.Product;
import com.example.domain.User;
import com.example.service.CartItemService;
import com.example.service.InventoryItemService;

@Controller
@Scope("session")
@RequestMapping(value = "/user")
public class CartController {
	
    @Autowired
    private CartItemService cartItemService;
    
    @Autowired
    private InventoryItemService inventoryItemService;

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public String addToCart(HttpSession session, ModelMap model, @RequestParam("inventoryId") int id,
                                @RequestParam("cartItemQuantity") int quantity) {
        Product product = inventoryItemService.getInventoryItem(id).getProduct();
        User user = (User) session.getAttribute("user");
        cartItemService.addToCart(user, product, quantity);
        model.put("message", "cart item added");
        return "forward:/user/home";
    }
    
    @RequestMapping(value = "/add-to-cart-view", method = RequestMethod.GET)
    public String viewAddToCart(HttpSession session, ModelMap model, @RequestParam("inventoryItemId") int id) {
        InventoryItem inventoryItem = inventoryItemService.getInventoryItem(id);
        model.put("inventoryItem", inventoryItem);
        model.put("message", "cart item added");
        return "add-to-cart";
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
    	return "forward:/user/cart";
    }
    
    @RequestMapping(value = "/edit-quantity-view", method = RequestMethod.GET)
    public String updateQuantityView(HttpSession session, ModelMap model, @RequestParam("cartItemId") int id) {
    	CartItem cartItem = cartItemService.getCartItem(id);
    	model.addAttribute("cartItem", cartItem);
    	return "forward:/edit-quantity-view";
    }
    
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(HttpSession session, ModelMap model) {
    	cartItemService.checkout((User) session.getAttribute("user"));
    	return "forward:/user/home";
    }
    
}
