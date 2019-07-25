package com.revature.dao;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.entity.*;

public interface UserDAO {
	
	/*
	 * public void addBook(Book book); public Book fetchBookbyId(int BookId); public
	 * void deleteBookById(Integer BookId); void updateBookById(int BookId, Float
	 * price);
	 */
	public List<User> getAllUsers();
	
	public User fetchUserbyId(int uid);

	void deleteUserById(Integer uid);
	
	void addUser(User user);
	
	
}
