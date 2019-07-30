package com.example.service;

import java.util.List;

import com.example.domain.CartItem;

public interface CartItemService {
	
    public List <CartItem> getCartItem();
    public void saveCartItem(CartItem cartItem);
    public CartItem getCartItem(int id);
    public void deleteCartItem(int id);
	
}
