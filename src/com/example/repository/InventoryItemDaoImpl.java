package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.InventoryItem;

@Repository
public class InventoryItemDaoImpl implements InventoryItemDao {

    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public List<InventoryItem> getInventoryItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveInventoryItem(InventoryItem inventoryItem) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(inventoryItem);
		
	}

	@Override
	public InventoryItem getInventoryItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInventoryItem(int id) {
		// TODO Auto-generated method stub
		
	}

}
