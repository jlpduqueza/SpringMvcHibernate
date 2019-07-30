package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CartItem;
import com.example.repository.CartItemDao;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;
	
	@Override
	public List<CartItem> getCartItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @Transactional
	public void saveCartItem(CartItem cartItem) {
		cartItemDao.saveCartItem(cartItem);
		
	}

	@Override
	public CartItem getCartItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCartItem(int id) {
		// TODO Auto-generated method stub
		
	}

}
