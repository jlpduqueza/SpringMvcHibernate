package com.example.repository;

import java.util.List;

import com.example.domain.CartItem;
import com.example.domain.User;

public interface CartItemDao {
	
    public List <CartItem> getCartItemList(User user);
    public void saveCartItem(CartItem cartItem);
    public CartItem getCartItem(int id);
    public void deleteCartItem(int id);
	
}
