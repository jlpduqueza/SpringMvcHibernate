package com.example.repository;

import java.util.List;

import com.example.domain.User;

public interface UserDao {
	
    public List < User > getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
	
}
