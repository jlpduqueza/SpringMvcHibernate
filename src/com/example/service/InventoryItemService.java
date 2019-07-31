package com.example.service;

import java.util.List;

import com.example.domain.InventoryItem;

public interface InventoryItemService {
	
    public List <InventoryItem> getInventoryList();
    public void saveInventoryItem(InventoryItem inventoryItem);
    public InventoryItem getInventoryItem(int id);
    public InventoryItem getInventoryItemByProductId(int id);
    public void deleteInventoryItem(int id);
	
}
