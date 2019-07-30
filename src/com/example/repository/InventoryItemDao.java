package com.example.repository;

import java.util.List;

import com.example.domain.InventoryItem;

public interface InventoryItemDao {
	
    public List <InventoryItem> getInventoryItem();
    public void saveInventoryItem(InventoryItem inventoryItem);
    public InventoryItem getInventoryItem(int id);
    public void deleteInventoryItem(int id);
	
}
