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
	@Transactional
	public List<InventoryItem> getInventoryList() {
		return inventoryItemDao.getInventoryList();
	}

	@Override
    @Transactional
	public void saveInventoryItem(InventoryItem inventoryItem) {
		inventoryItemDao.saveInventoryItem(inventoryItem);
	}

	@Override
	@Transactional
	public InventoryItem getInventoryItem(int id) {
		return inventoryItemDao.getInventoryItem(id);
	}

	@Override
	@Transactional
	public void deleteInventoryItem(int id) {
		inventoryItemDao.deleteInventoryItem(id);
	}
	
}
