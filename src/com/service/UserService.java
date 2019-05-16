package com.service;

import java.util.ArrayList;

import com.bean.Student;
import com.bean.User;
import com.dao.UserDao;

public class UserService {
	public int registerUser(User user){
		int result = 0;
		UserDao dao = new UserDao();
		boolean usernameFlag = dao.existUsername(user.getUsername());
		if(usernameFlag){
			result = -1;
		}else{
			boolean addFlag = dao.addUser(user);
			if(addFlag){
				result = 1;
			}
		}
		return result;
	}
	public int loginUser(User user){
		int result = 0;
		UserDao dao = new UserDao();
		User userFlag = dao.querUserByUsername(user.getUsername());
		if (userFlag == null) {
			result = -1;
		}else if (userFlag.getPassword().equals(user.getPassword())) {
			result = 1;
		}
		return result;
	}
}
