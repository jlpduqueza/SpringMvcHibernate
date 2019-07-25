package com.example.service;

import java.util.List;

import com.example.domain.User;

public interface UserService {

	public List <User> getUsers();
	public void saveUser(User user);
	public User getUser(int id);
	public void deleteUser(int id);
	
}
