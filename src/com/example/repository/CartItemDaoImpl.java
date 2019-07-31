package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CartItem;
import com.example.domain.User;

@Repository
public class CartItemDaoImpl implements CartItemDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public List<CartItem> getCartItemList(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from CartItem", CartItem.class).getResultList();
	}

	@Override
	public void saveCartItem(CartItem cartItem) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(cartItem);
	}

	@Override
	public CartItem getCartItem(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(CartItem.class, id);
	}

	@Override
	public void deleteCartItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        CartItem cartItem = session.byId(CartItem.class).load(id);
        session.delete(cartItem);
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public void checkout(User user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from CartItem where user_id = :userId");
        query.setParameter("userId", user.getId());
        query.executeUpdate();
	}

}
