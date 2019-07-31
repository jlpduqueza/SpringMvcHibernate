package com.example.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CartItem;
import com.example.domain.Product;
import com.example.domain.User;
import com.example.repository.CartItemDao;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;
	
	@Override
	@Transactional
	public List<CartItem> getCartItemList(User user) {
		return cartItemDao.getCartItemList(user);
	}

	@Override
    @Transactional
	public void saveCartItem(CartItem cartItem) {
		cartItemDao.saveCartItem(cartItem);
	}

	@Override
	@Transactional
	public CartItem getCartItem(int id) {
		return cartItemDao.getCartItem(id);
	}

	@Override
	@Transactional
	public void deleteCartItem(int id) {
		cartItemDao.deleteCartItem(id);
	}

	@Override
	@Transactional
	public BigDecimal generateSubTotal(int quantity, BigDecimal price) {
		return price.multiply(new BigDecimal(quantity));
	}

	@Override
	@Transactional
	public void addToCart(User user, Product product, int quantity) {
		CartItem cartItem = new CartItem();
		cartItem.setUser(user);
		cartItem.setProduct(product);
		cartItem.setQuantity(quantity);
		cartItem.setSubTotalPrice(generateSubTotal(quantity, product.getPrice()));
		saveCartItem(cartItem);
	}

	@Override
	@Transactional
	public void checkout(User user) {
		cartItemDao.checkout(user);
	}

}
