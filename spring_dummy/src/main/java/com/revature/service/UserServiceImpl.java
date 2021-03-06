package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.*;
import com.revature.entity.Car;
import com.revature.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAOImpl ud;
	
	@Override
	@Transactional
	public List<User> listAllUsers(){
		List <User> lu=ud.getAllUsers();
		List <User> customers = new ArrayList<User>();
		
		for(User user: lu) {
			if(user.getRole().equals("C")) {
				customers.add(user);
			}
		}
		
		System.out.println("list in service: "+ customers);
		return customers;
	}
	
	@Override
	@Transactional
	public User getUserbyId(int id) {
		User u = ud.fetchUserbyId(id);
		System.out.println("User" + u.toString());
		return u;
	}
	
	@Override
	@Transactional
	public User validateUser(String userName, String passWord) {
		List <User> lu=ud.getAllUsers();
		
		for(User user: lu) {
			if(user.getUsername().equals(userName)) {
				System.out.println("Found user " + userName);
				if(user.getPassword().equals(passWord)) {
					System.out.println("Logged in: " + user.toString());
					return user;
				}
				
			}
				
		}
		
		return null;
	}
	
	@Override
	@Transactional
	public void deleteUserbyId(int id) {
		ud.deleteUserById(id);
	}
	
	@Override
	@Transactional
	public void createUser(User user) {
		ud.addUser(user);
	}	
	
	@Override
	@Transactional
	public void updateUser(User user) {
		ud.addUser(user);
	}
	
	@Override
	@Transactional
	public void sendReset(String email) {
		System.out.println("SERVICE sending to: " + email);
		ud.sendJMail(email);
	}
	
	@Override
	@Transactional
	public void sendRecall(String email) {
		ud.recallJMail(email);
	}

	
}
