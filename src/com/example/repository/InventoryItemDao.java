package com.example.repository;

import java.util.List;

import com.example.domain.InventoryItem;

public interface InventoryItemDao {
	
    public List <InventoryItem> getInventoryList();
    public void saveInventoryItem(InventoryItem inventoryItem);
    public InventoryItem getInventoryItem(int id);
    public InventoryItem getInventoryItemByProductId(int id);
    public void deleteInventoryItem(int id);
}
