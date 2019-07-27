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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.entity.Car;
import com.revature.entity.User;
import com.revature.service.CarService;
import com.revature.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService us;
	
	@GetMapping("/users")
	public List<User> hello(Model model) {
		List <User> al = us.listAllUsers();
		System.out.println("List is: ");
		al.forEach(System.out::println);
		return al;
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public User findUser(@PathVariable int id) {
		System.out.println(id);
		User u = us.getUserbyId(id);
		System.out.println(u.toString());
		return u;
	}
	
	@RequestMapping(value="/resetPassword/{email}", method=RequestMethod.GET)
	public void reset(@PathVariable String email) {  //?
		email += ".com";
		System.out.println("sending to: " + email);
		us.sendReset(email);
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public User login(@RequestParam("user") String user, @RequestParam("pass") String pass) {
		System.out.println("Attempting to Log: " + user + ", " + pass);
		User u = us.validateUser(user, pass);
		//System.out.println("WELCOME " + u.toString());
		return u;
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		us.createUser(user);
		System.out.println(user);
		return user;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		us.createUser(user);
		System.out.println(user);
		return user;
	}
	
}
