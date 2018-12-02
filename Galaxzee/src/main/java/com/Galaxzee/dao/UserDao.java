package com.Galaxzee.dao;

import java.util.List;

import com.Galaxzee.model.User;



public interface UserDao 
{
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean delete(int userId); 

	public User getUser(int userId);
	public User getUserByEmail(String userEmail);
	public List<User> listUsers();
}
