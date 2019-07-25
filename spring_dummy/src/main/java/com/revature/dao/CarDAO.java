package com.revature.dao;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.entity.*;

public interface CarDAO {
	
	/*
	 * public void addBook(Book book); public Book fetchBookbyId(int BookId); public
	 * void deleteBookById(Integer BookId); void updateBookById(int BookId, Float
	 * price);
	 */
	public List<Car> getAllCars();
	
	public Car fetchCarbyId(int bid);

	void deleteCarById(Integer bid);
	
	void addCar(Car car);
	
}
