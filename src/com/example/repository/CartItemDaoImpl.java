package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public List<CartItem> getCartItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCartItem(CartItem cartItem) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(cartItem);
		
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
