package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.*;
import com.revature.entity.Car;

@Service("carService")
public class CarServiceImpl implements CarService{
	
	@Autowired
	CarDAOImpl cd;
	
	@Override
	@Transactional
	public List<Car> listAllCars(){
		List <Car> lc=cd.getAllCars();
		System.out.println("list in service: "+lc);
		return lc;
	}
	
	@Override
	@Transactional
	public Car getCarbyId(int id) {
		Car c = cd.fetchCarbyId(id);
		System.out.println("Car" + c.toString());
		return c;
	}
	
	@Override
	@Transactional
	public List<Car> getCarbyModel(String model) {
		List<Car> lc = cd.getAllCars();
		List<Car> resultCars = new ArrayList<Car>();
		
		for(Car car : lc) {
			if(model.toLowerCase().equals(car.getModel().toLowerCase())) {
				System.out.println("MATCH! " + car.getModel() + " is a " + model);
				resultCars.add(car);
			}
			else {
				System.out.println(car.getModel() + " is not a " + model);
			}
		}
		System.out.println("The results are: " + resultCars.toString());
		return resultCars;
	}
	
	@Override
	@Transactional
	public void deleteCarbyId(int id) {
		cd.deleteCarById(id);
	}
	
	@Override
	@Transactional
	public void createCar(Car car) {
		cd.addCar(car);
	}	
	
	@Override
	@Transactional
	public void updateCar(Car car) {
		cd.addCar(car);
	}
	
}
