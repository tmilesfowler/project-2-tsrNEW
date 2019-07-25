package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.entity.Car;
import com.revature.service.CarService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	CarService cs;
	
	@GetMapping("/cars")
	public List <Car> hello(Model model) {
		List <Car> al = cs.listAllCars();
		System.out.println("List is: ");
		al.forEach(System.out::println);
		return al;
	}
	
	@RequestMapping(value="/cars/{id}", method=RequestMethod.GET)
	public Car findCar(@PathVariable int id) {
		System.out.println(id);
		Car c = cs.getCarbyId(id);
		System.out.println(c.toString());
		return c;
	}
	
	@RequestMapping(value="/car/{model}", method=RequestMethod.GET)
	public List <Car> searchCar(@PathVariable String model) {
		System.out.println("Initiating search for " + model);
		List c = cs.getCarbyModel(model);
		//System.out.println(c.toString());
		return c;
	}
	
	@PostMapping("/cars")
	public Car createCar(@RequestBody Car car) {
		cs.createCar(car);
		System.out.println(car);
		return car;
	}
	
	@RequestMapping(value="/car", method=RequestMethod.PUT)
	public Car updateCar(@RequestBody Car car) {
		cs.createCar(car);
		System.out.println(car);
		return car;
	}
	
	@RequestMapping(value="/cars/{id}", method=RequestMethod.DELETE)
	public String carBook(@PathVariable("id") int id) {
		cs.deleteCarbyId(id);
		System.out.println("Delete Called");
		return "Deleted";
			
	}
	
}
