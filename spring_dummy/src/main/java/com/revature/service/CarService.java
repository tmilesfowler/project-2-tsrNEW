package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.entity.*;

public interface CarService {
//	public void createBook(Book book);
//	public Book getBookbyId(int BookId);
//	public void updateBookById(int BookId, Float price);
//	public void deleteBookById(Integer BookId);
	public List<Car> listAllCars();

	public Car getCarbyId(int id);
	
	public List<Car> getCarbyModel(String model);

	void deleteCarbyId(int id);
	
	public void createCar(Car car);
	
	void updateCar(Car car);
	
	
}

