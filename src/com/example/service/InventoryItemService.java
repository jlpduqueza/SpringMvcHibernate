package com.example.service;

import java.util.List;

import com.example.domain.InventoryItem;

public interface InventoryItemService {
	
    public List <InventoryItem> getInventoryItem();
    public void saveInventoryItem(InventoryItem inventoryItem);
    public InventoryItem getInventoryItem(int id);
    public void deleteInventoryItem(int id);
	
}