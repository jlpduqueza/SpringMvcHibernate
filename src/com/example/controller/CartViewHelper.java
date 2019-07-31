package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.CartItem;
import com.example.domain.InventoryItem;
import com.example.domain.User;
import com.example.service.CartItemService;
import com.example.service.InventoryItemService;

public class CartViewHelper {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private InventoryItemService inventoryItemService;
	
	public Map<CartItem, Integer> generateBean(User user) {
		
		Map<CartItem, Integer> cartBeanMap = new HashMap<>();
		List<CartItem> cartItemList = cartItemService.getCartItemList(user);
		
		for(CartItem cartItem : cartItemList) {
			InventoryItem inventoryItem;
			inventoryItem = inventoryItemService.getInventoryItemByProductId(cartItem.getProduct().getId());

			cartBeanMap.put(cartItem, inventoryItem.getQuantity());
		}
		
		return cartBeanMap;
		
	}
}
