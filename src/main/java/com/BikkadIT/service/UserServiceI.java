package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.entity.User;

public interface UserServiceI {
	public int saveUser(User user);
	
	public boolean loginCheckServiceLayer(User user);
	
	public List<User> getAll();
	
	public User singleUser(int uid);
	
	public List<User> updateUser(User user);
	
	public User deleteuser(int uid);
	
	

		
	

}
