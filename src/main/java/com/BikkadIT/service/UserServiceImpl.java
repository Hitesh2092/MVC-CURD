package com.BikkadIT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.dao.UserDaoI;
import com.BikkadIT.entity.User;

@Service
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private UserDaoI userDaoI;

	@Override
	public int saveUser(User user) {
		System.out.println("Service layer method");
		System.out.println(user);
		int id = userDaoI.saveUserToDb(user);
		
		return id;
	}

	@Override
	public boolean loginCheckServiceLayer(User user) {
		
		List<User> allData = userDaoI.getAllData();
		for(User user1:allData) {
			if(user.getUname().equals(user1.getUname())&&(user.getPassword().equals(user1.getPassword())))
					{
				return true;
					}
		}
		return false;
	}

	@Override
	public List<User> getAll() {
		List<User> list = userDaoI.getAllDataFromDB();
		return list;
	}
	
	@Override
	public User singleUser(int uid) {
		User singleuser = userDaoI.getsingle(uid);
		return singleuser;
	}

	@Override
	public List<User> updateUser(User user) {
		List<User> updateUser = userDaoI.updateUser(user);
		return updateUser;
	}


	@Override		
	public User deleteuser(int uid) {
		userDaoI.deleteuser(uid);
		return null;
	}

	
	

}
