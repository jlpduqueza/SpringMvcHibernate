package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.InventoryItem;
import com.example.repository.InventoryItemDao;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    @Autowired
    private InventoryItemDao inventoryItemDao;
	
	@Override
	public List<InventoryItem> getInventoryItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @Transactional
	public void saveInventoryItem(InventoryItem inventoryItem) {
		inventoryItemDao.saveInventoryItem(inventoryItem);
		
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
