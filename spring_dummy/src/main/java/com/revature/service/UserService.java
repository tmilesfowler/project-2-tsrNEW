package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.entity.*;

public interface UserService {
//	public void createBook(Book book);
//	public Book getBookbyId(int BookId);
//	public void updateBookById(int BookId, Float price);
//	public void deleteBookById(Integer BookId);
	public List<User> listAllUsers();

	public User getUserbyId(int id);
	
	public User validateUser(String user, String pass);
	
	void deleteUserbyId(int id);
	
	public void createUser(User user);
	
	void updateUser(User user);
	
	
}

